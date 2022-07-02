// Generated from Secondary.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SecondaryParser}.
 */
public interface SecondaryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SecondaryParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SecondaryParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SecondaryParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SecondaryParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SecondaryParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SecondaryParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SecondaryParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SecondaryParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SecondaryParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(SecondaryParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SecondaryParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(SecondaryParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SecondaryParser#pal}.
	 * @param ctx the parse tree
	 */
	void enterPal(SecondaryParser.PalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SecondaryParser#pal}.
	 * @param ctx the parse tree
	 */
	void exitPal(SecondaryParser.PalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SecondaryParser#opt}.
	 * @param ctx the parse tree
	 */
	void enterOpt(SecondaryParser.OptContext ctx);
	/**
	 * Exit a parse tree produced by {@link SecondaryParser#opt}.
	 * @param ctx the parse tree
	 */
	void exitOpt(SecondaryParser.OptContext ctx);
}