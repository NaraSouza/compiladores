// Generated from /home/nara/Documentos/UFPE/Compiladores/compiladores/atividade4/MiniJava-master (copy)/src/main/java/antlr/grammarMinijava.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link grammarMinijavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface grammarMinijavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(grammarMinijavaParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(grammarMinijavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(grammarMinijavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(grammarMinijavaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(grammarMinijavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(grammarMinijavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(grammarMinijavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(grammarMinijavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(grammarMinijavaParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarMinijavaParser#integer_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_literal(grammarMinijavaParser.Integer_literalContext ctx);
}