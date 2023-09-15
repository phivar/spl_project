package spl.interpreter;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import spl.interpreter.errors.FatalException;
import spl.interpreter.errors.TypeException;
import spl.parser.SPLBaseVisitor;
import spl.parser.SPLParser;
import spl.parser.SPLVisitor;
import spl.parser.SPLLexer;

import java.util.ArrayList;

// Responsible for executing a parse tree in a given scope (SymbolTable).
// Also stores return value if the code block defines one.
public class ExecutingVisitor extends  SPLBaseVisitor<Value> implements SPLVisitor<Value> {
    private final SymbolTable table;
    private boolean returnFlag = false;
    private Value returnValue = Value.VOID;
    public ExecutingVisitor(SymbolTable table){
        this.table = table;
    }

    public Value getReturnValue() {
        return returnValue;
    }

    // the two methods below implement the following rule:
    /*
      varDecl : KW_VAR boundedIdent ASSIGN expression SEMICOLON   #varDeclAndAssign
        | KW_VAR ident=IDENTIFIER SEMICOLON                       #simpleVarDecl
        ;
    */
    @Override
    public Value visitVarDeclAndAssign(SPLParser.VarDeclAndAssignContext ctx) {
        Value val = visit(ctx.expression());
        table.declareToken(ctx.boundedIdent().ident, extractBound(ctx.boundedIdent()));
        table.assignToken(ctx.boundedIdent().ident, val);
        return Value.VOID;
    }
    @Override
    public Value visitSimpleVarDecl(SPLParser.SimpleVarDeclContext ctx) {
        table.declareToken(ctx.ident, SymbolTable.TypeBound.ANY);
        return Value.VOID;
    }


    @Override
    public Value visitIdentifierAssign(SPLParser.IdentifierAssignContext ctx) {
        Value val = visit(ctx.assignment());
        table.assignToken(ctx.start, val);
        return val;
    }

    // printStmt : KW_PRINT expression SEMICOLON ;
    @Override
    public Value visitPrintStmt(SPLParser.PrintStmtContext ctx) {
        Value val = visit(ctx.expression());
        System.out.println(val.toString());
        return Value.VOID;
    }

    // the two methods blow implement the following rule:
    /*
        ifStmt : KW_IF LPAREN expression RPAREN statement KW_ELSE statement     #ifElseStatement
           | KW_IF LPAREN expression RPAREN statement                          #simpleIfStatement
           ;
    */
    @Override
    public Value visitSimpleIfStatement(SPLParser.SimpleIfStatementContext ctx) {
        Value cond = visit(ctx.expression());
        assertBool(ctx.expression(), cond);
        if(cond.forceBool()) visit(ctx.statement());
        return Value.VOID;
    }
    @Override
    public Value visitIfElseStatement(SPLParser.IfElseStatementContext ctx) {
        Value cond = visit(ctx.expression());
        assertBool(ctx.expression(), cond);
        if(cond.forceBool()) visit(ctx.statement(0));
        else visit(ctx.statement(1));
        return Value.VOID;
    }

    // whileStmt : KW_WHILE LPAREN expression RPAREN statement ;
    @Override
    public Value visitWhileStmt(SPLParser.WhileStmtContext ctx) {
        while(true){
            Value cond = visit(ctx.expression());
            assertBool(ctx.expression(), cond);
            if(!cond.forceBool()) break;
            visit(ctx.statement());
        }
        return Value.VOID;
    }

    // returnStmt: KW_RETURN expression SEMICOLON ;
    @Override
    public Value visitReturnStmt(SPLParser.ReturnStmtContext ctx) {
        if(ctx.expression() != null) {
            Value val = visit(ctx.expression());
            returnValue = val;
        }
        returnFlag = true;
        return Value.VOID;
    }

    // block : LCURLY declartionList RCURLY ;
    @Override
    public Value visitBlock(SPLParser.BlockContext ctx) {
        SymbolTable scope = new SymbolTable();
        scope.setParent(table);
        ExecutingVisitor visitor = new ExecutingVisitor(scope);
        visitor.visit(ctx.declartionList());
        returnFlag = visitor.returnFlag;
        returnValue = visitor.returnValue;
        return Value.VOID;
    }

    // declartionList : declaration*;
    @Override
    public Value visitDeclartionList(SPLParser.DeclartionListContext ctx) {
        for(SPLParser.DeclarationContext decl : ctx.declaration()){
            visit(decl);
            if(returnFlag) return Value.VOID;
        }
        return Value.VOID;
    }

    // evaluates primary rule:
    /*
    primary : KW_TRUE | KW_FALSE | NUMBER | STRING
        | LPAREN expression RPAREN
        | LSQUARE expressionList RSQUARE
        | KW_FUNC LPAREN paramList RPAREN block
        | ident=IDENTIFIER ;
    */
    @Override
    public Value visitPrimary(SPLParser.PrimaryContext ctx) {
        return switch(ctx.start.getType()){
            case SPLLexer.KW_TRUE -> Value.TRUE;
            case SPLLexer.KW_FALSE -> Value.FALSE;
            case SPLLexer.NUMBER -> new Value(Double.parseDouble(ctx.start.getText()));
            case SPLLexer.STRING -> {String s = ctx.start.getText();  yield new Value(s.substring(1,s.length()-1));}
            case SPLLexer.LPAREN -> visit(ctx.expression());
            case SPLLexer.LSQUARE -> visit(ctx.expressionList());
            case SPLLexer.KW_FUNC -> createFunction(ctx);
            case SPLLexer.IDENTIFIER ->  table.lookupToken(ctx.ident);
            default -> throw new FatalException("impossible parse of primary term");
        };
    }

    // Utility function used for the primary rule to create a FunctionRecord.
    private Value createFunction(SPLParser.PrimaryContext ctx){
        ParserRuleContext body = ctx.block();
        ArrayList<Pair<String, SymbolTable.TypeBound>> params = readParamList(ctx.paramList());
        return new Value(new SPLFunction(table, body, params));
    }
    // Utility function used by createFunction to parse the parameter list.
    // paramList : (boundedIdent ( COMMA boundedIdent)*)?;
    private ArrayList<Pair<String, SymbolTable.TypeBound>> readParamList(SPLParser.ParamListContext ctx){
        ArrayList<Pair<String, SymbolTable.TypeBound>> params = new ArrayList<>();
        for(SPLParser.BoundedIdentContext elem : ctx.boundedIdent()){
            params.add(new Pair<>(elem.ident.getText(), extractBound(elem)));
        }
        return params;
    }
    // Utility function to extract a TypeBound from a bounded identifier:
    // boundedIdent: ident=IDENTIFIER (COLON bound = type)?;
    private SymbolTable.TypeBound extractBound(SPLParser.BoundedIdentContext ctx){
        if(ctx.bound == null) return SymbolTable.TypeBound.ANY;
        return switch(ctx.bound.start.getType()){
            case SPLLexer.KW_ANY -> SymbolTable.TypeBound.ANY;
            case SPLLexer.KW_BOOL -> SymbolTable.TypeBound.BOOL;
            case SPLLexer.KW_NUMBER -> SymbolTable.TypeBound.FLOAT;
            case SPLParser.KW_STRING -> SymbolTable.TypeBound.STRING;
            case SPLParser.KW_LIST -> SymbolTable.TypeBound.LIST;
            case SPLParser.KW_FUNC-> SymbolTable.TypeBound.FUNC;
            default -> throw new FatalException("parsed illegal type bound");
        };
    }

    // expressionList: (expression (COMMA expression)*)?;
    @Override
    public Value visitExpressionList(SPLParser.ExpressionListContext ctx) {
        ArrayList<Value> list = new ArrayList<>();
        for(SPLParser.ExpressionContext expr : ctx.expression()){
            list.add(visit(expr));
        }
        return new Value(list);
    }

    // the following methods all deal with the branches of the term rule:
    /*
    term : primary                  #primaryTerm
        | term LPAREN arguments=expressionList RPAREN  #functionCallTerm
        | op=(NOT|SUB) term            #unaryTerm
        | term op=(MUL|DIV) term       #mulDivTerm
        | term op=(ADD|SUB) term       #addSubTerm
        | term op=(GT|GTE|LT|LTE) term #comparisonTerm
        | term op=(NEQ|EQ) term        #equalityTerm
        | term AND term             #andTerm
        | term OR term              #orTerm
        ;
    */
    //  term: | term LPAREN arguments=expressionList RPAREN  #functionCallTerm
    @Override
    public Value visitFunctionCallTerm(SPLParser.FunctionCallTermContext ctx) {
        Value func = visit(ctx.term());
        Value argList = visitExpressionList(ctx.expressionList());
        assertFunc(ctx, func);
        return func.forceFunc().execute(ctx, argList.forceList());
    }

    // term: | op=(NOT|SUB) term            #unaryTerm
    @Override
    public Value visitUnaryTerm(SPLParser.UnaryTermContext ctx) {
        Value val = visit(ctx.term());
        return switch(ctx.op.getType()){
            case SPLLexer.SUB ->
                {assertFloat(ctx, val); yield val.neg();}
            default /*SPLLexer.NOT*/ ->
                {assertBool(ctx, val); yield val.not();}
        };
    }

    // term: | term op=(MUL|DIV) term       #mulDivTerm
    @Override
    public Value visitMulDivTerm(SPLParser.MulDivTermContext ctx) {
        Value left = visit(ctx.term(0));
        Value right = visit(ctx.term(1));
        assertFloat(ctx.term(0), left);
        assertFloat(ctx.term(1), right);
        return switch(ctx.op.getType()){
            case SPLLexer.MUL -> left.mul(right);
            default /*SPLLexer.DIV*/ -> left.div(right);
        };
    }

    // term: | term op=(ADD|SUB) term       #addSubTerm
    @Override
    public Value visitAddSubTerm(SPLParser.AddSubTermContext ctx) {
        Value left = visit(ctx.term(0));
        Value right = visit(ctx.term(1));
        assertFloat(ctx.term(0), left);
        assertFloat(ctx.term(1), right);
        return switch(ctx.op.getType()){
            case SPLLexer.ADD -> left.add(right);
            default /*SPLLexer.SUB*/ -> left.sub(right);
        };
    }
    // term: | term op=(GT|GTE|LT|LTE) term #comparisonTerm
    @Override
    public Value visitComparisonTerm(SPLParser.ComparisonTermContext ctx) {
        Value left = visit(ctx.term(0));
        Value right = visit(ctx.term(1));
        assertFloat(ctx.term(0), left);
        assertFloat(ctx.term(1), right);
        double l = left.forceFloat(), r = right.forceFloat();
        return Value.fromBool(switch(ctx.op.getType()){
            case SPLLexer.LT -> l < r;
            case SPLLexer.LTE -> l <= r;
            case SPLLexer.GT -> l > r;
            default /*GTE*/ -> l >= r;
        });
    }
    // term: | term op=(NEQ|EQ) term        #equalityTerm
    @Override
    public Value visitEqualityTerm(SPLParser.EqualityTermContext ctx) {
        Value left = visit(ctx.term(0));
        Value right = visit(ctx.term(1));
        if(left.type != right.type) throw TypeException.unequalTypesFromContext(ctx, left.type, right.type);
        return switch(ctx.op.getType()){
            case SPLLexer.EQ -> left.eq(right);
            default /*NEQ*/ -> left.neq(right);
        };
    }
    // term: | term AND term             #andTerm
    @Override
    public Value visitAndTerm(SPLParser.AndTermContext ctx) {
        Value left = visit(ctx.term(0));
        Value right = visit(ctx.term(1));
        assertBool(ctx.term(0), left);
        assertBool(ctx.term(1), right);
        return left.and(right);
    }
    // term: | term OR term              #orTerm
    @Override
    public Value visitOrTerm(SPLParser.OrTermContext ctx) {
        Value left = visit(ctx.term(0));
        Value right = visit(ctx.term(1));
        assertBool(ctx.term(0), left);
        assertBool(ctx.term(1), right);
        return left.or(right);
    }

    // Utility function to check if a value has a certain type.
    // If the type bound is not satisfied throw an error
    private void assertType(ParserRuleContext ctx, SymbolTable.TypeBound bound, Value val){
        if(bound.satisfiedBy(val.type)) return;
        throw TypeException.createTypeMismatchFromContext(ctx,bound,val.type);
    }
    private void assertFloat(ParserRuleContext ctx, Value val){
        assertType(ctx, SymbolTable.TypeBound.FLOAT, val);
    }
    private void assertBool(ParserRuleContext ctx, Value val){
        assertType(ctx, SymbolTable.TypeBound.BOOL, val);
    }
    private void assertFunc(ParserRuleContext ctx, Value val){
        assertType(ctx, SymbolTable.TypeBound.FUNC, val);
    }
}
