// Generated from /home/nara/Downloads/MiniJava-master (copy)/src/main/java/antlr/grammarMinijava.g4 by ANTLR 4.7.2
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
}