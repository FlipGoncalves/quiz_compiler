// Generated from Secondary.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SecondaryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SecondaryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SecondaryParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SecondaryParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SecondaryParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SecondaryParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SecondaryParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(SecondaryParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SecondaryParser#pal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPal(SecondaryParser.PalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SecondaryParser#opt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt(SecondaryParser.OptContext ctx);
}