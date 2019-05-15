// Generated from /home/nara/Documentos/UFPE/Compiladores/compiladores/atividade4/MiniJava-master (copy)/src/main/java/antlr/grammarMinijava.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammarMinijavaParser}.
 */
public interface grammarMinijavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(grammarMinijavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(grammarMinijavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(grammarMinijavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(grammarMinijavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(grammarMinijavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(grammarMinijavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(grammarMinijavaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(grammarMinijavaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(grammarMinijavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(grammarMinijavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(grammarMinijavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(grammarMinijavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(grammarMinijavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(grammarMinijavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarMinijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(grammarMinijavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarMinijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(grammarMinijavaParser.ExpressionContext ctx);
}