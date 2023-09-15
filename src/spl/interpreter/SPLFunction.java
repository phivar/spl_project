package spl.interpreter;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

// Implements the FunctionRecord for functions defined in SPL.
// funcEntryPoint refers to the parse tree of the body of the function.
// parentScope is the scope in which the function originally was defined.
public class SPLFunction extends FunctionRecord {


    private final ParserRuleContext funcEntryPoint;

    private final SymbolTable parentScope;


    // Type checks the argument list and proceeds to execute the function by creating a new internal scope,
    // declaring and assigning all the parameters and creating a ExecutingVisitor on the function body.
    // Finally, the return value is extracted from the Visitor.
    public Value execute(ParserRuleContext ctx, ArrayList<Value> arguments) {
        typeCheckArgumentList(ctx, arguments);
        SymbolTable scope = new SymbolTable();
        scope.setParent(parentScope);
        for(int i = 0; i < parameterList.size(); i++){
            scope.put(parameterList.get(i).a, parameterList.get(i).b, arguments.get(i));
        }
        ExecutingVisitor visitor = new ExecutingVisitor(scope);
        visitor.visit(funcEntryPoint);
        return visitor.getReturnValue();
    }

    public SPLFunction(SymbolTable scope, ParserRuleContext funcEntryPoint, ArrayList<Pair<String, SymbolTable.TypeBound>> params){
        this.funcEntryPoint = funcEntryPoint;
        this.parentScope = scope;
        this.parameterList = params;
    }
}
