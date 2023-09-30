// Generated from C:/Users/abc/Desktop/compbau/spl/src\SPL.g4 by ANTLR 4.12.0
package spl.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SPLParser}.
 */
public interface SPLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SPLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SPLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SPLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SPLParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SPLParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#declartionList}.
	 * @param ctx the parse tree
	 */
	void enterDeclartionList(SPLParser.DeclartionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#declartionList}.
	 * @param ctx the parse tree
	 */
	void exitDeclartionList(SPLParser.DeclartionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclAndAssign}
	 * labeled alternative in {@link SPLParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclAndAssign(SPLParser.VarDeclAndAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclAndAssign}
	 * labeled alternative in {@link SPLParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclAndAssign(SPLParser.VarDeclAndAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleVarDecl}
	 * labeled alternative in {@link SPLParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterSimpleVarDecl(SPLParser.SimpleVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleVarDecl}
	 * labeled alternative in {@link SPLParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitSimpleVarDecl(SPLParser.SimpleVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#boundedIdent}.
	 * @param ctx the parse tree
	 */
	void enterBoundedIdent(SPLParser.BoundedIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#boundedIdent}.
	 * @param ctx the parse tree
	 */
	void exitBoundedIdent(SPLParser.BoundedIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SPLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SPLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SPLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SPLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(SPLParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(SPLParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link SPLParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(SPLParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link SPLParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(SPLParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleIfStatement}
	 * labeled alternative in {@link SPLParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleIfStatement(SPLParser.SimpleIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleIfStatement}
	 * labeled alternative in {@link SPLParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleIfStatement(SPLParser.SimpleIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(SPLParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(SPLParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(SPLParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(SPLParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(SPLParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(SPLParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SPLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SPLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SPLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SPLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(SPLParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(SPLParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierAssign}
	 * labeled alternative in {@link SPLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierAssign(SPLParser.IdentifierAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierAssign}
	 * labeled alternative in {@link SPLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierAssign(SPLParser.IdentifierAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyAssign}
	 * labeled alternative in {@link SPLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterEmptyAssign(SPLParser.EmptyAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyAssign}
	 * labeled alternative in {@link SPLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitEmptyAssign(SPLParser.EmptyAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterUnaryTerm(SPLParser.UnaryTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitUnaryTerm(SPLParser.UnaryTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAddSubTerm(SPLParser.AddSubTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAddSubTerm(SPLParser.AddSubTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryTerm(SPLParser.PrimaryTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryTerm(SPLParser.PrimaryTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterOrTerm(SPLParser.OrTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitOrTerm(SPLParser.OrTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallTerm(SPLParser.FunctionCallTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallTerm(SPLParser.FunctionCallTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAndTerm(SPLParser.AndTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAndTerm(SPLParser.AndTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMulDivTerm(SPLParser.MulDivTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMulDivTerm(SPLParser.MulDivTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterComparisonTerm(SPLParser.ComparisonTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitComparisonTerm(SPLParser.ComparisonTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterEqualityTerm(SPLParser.EqualityTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitEqualityTerm(SPLParser.EqualityTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SPLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SPLParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPLParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(SPLParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPLParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(SPLParser.ParamListContext ctx);
}