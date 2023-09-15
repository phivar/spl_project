// Generated from C:/Users/abc/Desktop/compbau/spl/src\SPL.g4 by ANTLR 4.12.0
package spl.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SPLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SPLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SPLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SPLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SPLParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#declartionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclartionList(SPLParser.DeclartionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclAndAssign}
	 * labeled alternative in {@link SPLParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclAndAssign(SPLParser.VarDeclAndAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleVarDecl}
	 * labeled alternative in {@link SPLParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleVarDecl(SPLParser.SimpleVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#boundedIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundedIdent(SPLParser.BoundedIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SPLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SPLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(SPLParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link SPLParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(SPLParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleIfStatement}
	 * labeled alternative in {@link SPLParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIfStatement(SPLParser.SimpleIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(SPLParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(SPLParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(SPLParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SPLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SPLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(SPLParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierAssign}
	 * labeled alternative in {@link SPLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierAssign(SPLParser.IdentifierAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyAssign}
	 * labeled alternative in {@link SPLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyAssign(SPLParser.EmptyAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryTerm(SPLParser.UnaryTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubTerm(SPLParser.AddSubTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryTerm(SPLParser.PrimaryTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrTerm(SPLParser.OrTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallTerm(SPLParser.FunctionCallTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndTerm(SPLParser.AndTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivTerm(SPLParser.MulDivTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonTerm(SPLParser.ComparisonTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityTerm}
	 * labeled alternative in {@link SPLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityTerm(SPLParser.EqualityTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SPLParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPLParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(SPLParser.ParamListContext ctx);
}