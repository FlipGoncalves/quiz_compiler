// Generated from Quizz.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuizzParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuizzVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuizzParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(QuizzParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(QuizzParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(QuizzParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclAssign}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclAssign(QuizzParser.DeclAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(QuizzParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(QuizzParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#quiz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuiz(QuizzParser.QuizContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuizzParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextString}
	 * labeled alternative in {@link QuizzParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextString(QuizzParser.TextStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextExpr}
	 * labeled alternative in {@link QuizzParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextExpr(QuizzParser.TextExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberValue}
	 * labeled alternative in {@link QuizzParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(QuizzParser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link QuizzParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(QuizzParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(QuizzParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#bquest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBquest(QuizzParser.BquestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumInt}
	 * labeled alternative in {@link QuizzParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumInt(QuizzParser.NumIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumDouble}
	 * labeled alternative in {@link QuizzParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumDouble(QuizzParser.NumDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultipleChoice}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoice(QuizzParser.MultipleChoiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Matching}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching(QuizzParser.MatchingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShortAnswer}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswer(QuizzParser.ShortAnswerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericAnswer}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericAnswer(QuizzParser.NumericAnswerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Essay}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEssay(QuizzParser.EssayContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(QuizzParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#shuffle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShuffle(QuizzParser.ShuffleContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(QuizzParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(QuizzParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericIteration}
	 * labeled alternative in {@link QuizzParser#cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericIteration(QuizzParser.NumericIterationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TableIteration}
	 * labeled alternative in {@link QuizzParser#cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableIteration(QuizzParser.TableIterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(QuizzParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizzParser#breakOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakOperation(QuizzParser.BreakOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Item}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(QuizzParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(QuizzParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exponent}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponent(QuizzParser.ExponentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisOper}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisOper(QuizzParser.ParenthesisOperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SignOper}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignOper(QuizzParser.SignOperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubtract}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubtract(QuizzParser.AddSubtractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarComp}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarComp(QuizzParser.VarCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCond(QuizzParser.NotCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondComp}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondComp(QuizzParser.CondCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisCond}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisCond(QuizzParser.ParenthesisCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleId}
	 * labeled alternative in {@link QuizzParser#methods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleId(QuizzParser.SingleIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Method}
	 * labeled alternative in {@link QuizzParser#methods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(QuizzParser.MethodContext ctx);
}