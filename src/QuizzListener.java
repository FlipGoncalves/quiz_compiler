// Generated from Quizz.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuizzParser}.
 */
public interface QuizzListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuizzParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(QuizzParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(QuizzParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(QuizzParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(QuizzParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(QuizzParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(QuizzParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclAssign}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterDeclAssign(QuizzParser.DeclAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclAssign}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitDeclAssign(QuizzParser.DeclAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssign(QuizzParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssign(QuizzParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterDecl(QuizzParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link QuizzParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitDecl(QuizzParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#quiz}.
	 * @param ctx the parse tree
	 */
	void enterQuiz(QuizzParser.QuizContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#quiz}.
	 * @param ctx the parse tree
	 */
	void exitQuiz(QuizzParser.QuizContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuizzParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuizzParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextString}
	 * labeled alternative in {@link QuizzParser#text}.
	 * @param ctx the parse tree
	 */
	void enterTextString(QuizzParser.TextStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextString}
	 * labeled alternative in {@link QuizzParser#text}.
	 * @param ctx the parse tree
	 */
	void exitTextString(QuizzParser.TextStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextExpr}
	 * labeled alternative in {@link QuizzParser#text}.
	 * @param ctx the parse tree
	 */
	void enterTextExpr(QuizzParser.TextExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextExpr}
	 * labeled alternative in {@link QuizzParser#text}.
	 * @param ctx the parse tree
	 */
	void exitTextExpr(QuizzParser.TextExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberValue}
	 * labeled alternative in {@link QuizzParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberValue(QuizzParser.NumberValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberValue}
	 * labeled alternative in {@link QuizzParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberValue(QuizzParser.NumberValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link QuizzParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(QuizzParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link QuizzParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(QuizzParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(QuizzParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(QuizzParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#bquest}.
	 * @param ctx the parse tree
	 */
	void enterBquest(QuizzParser.BquestContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#bquest}.
	 * @param ctx the parse tree
	 */
	void exitBquest(QuizzParser.BquestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumInt}
	 * labeled alternative in {@link QuizzParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumInt(QuizzParser.NumIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumInt}
	 * labeled alternative in {@link QuizzParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumInt(QuizzParser.NumIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumDouble}
	 * labeled alternative in {@link QuizzParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumDouble(QuizzParser.NumDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumDouble}
	 * labeled alternative in {@link QuizzParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumDouble(QuizzParser.NumDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultipleChoice}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoice(QuizzParser.MultipleChoiceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultipleChoice}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoice(QuizzParser.MultipleChoiceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Matching}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMatching(QuizzParser.MatchingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Matching}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMatching(QuizzParser.MatchingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShortAnswer}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswer(QuizzParser.ShortAnswerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShortAnswer}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswer(QuizzParser.ShortAnswerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumericAnswer}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNumericAnswer(QuizzParser.NumericAnswerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumericAnswer}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNumericAnswer(QuizzParser.NumericAnswerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Essay}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void enterEssay(QuizzParser.EssayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Essay}
	 * labeled alternative in {@link QuizzParser#type}.
	 * @param ctx the parse tree
	 */
	void exitEssay(QuizzParser.EssayContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(QuizzParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(QuizzParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#shuffle}.
	 * @param ctx the parse tree
	 */
	void enterShuffle(QuizzParser.ShuffleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#shuffle}.
	 * @param ctx the parse tree
	 */
	void exitShuffle(QuizzParser.ShuffleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(QuizzParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(QuizzParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(QuizzParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(QuizzParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumericIteration}
	 * labeled alternative in {@link QuizzParser#cycle}.
	 * @param ctx the parse tree
	 */
	void enterNumericIteration(QuizzParser.NumericIterationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumericIteration}
	 * labeled alternative in {@link QuizzParser#cycle}.
	 * @param ctx the parse tree
	 */
	void exitNumericIteration(QuizzParser.NumericIterationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TableIteration}
	 * labeled alternative in {@link QuizzParser#cycle}.
	 * @param ctx the parse tree
	 */
	void enterTableIteration(QuizzParser.TableIterationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TableIteration}
	 * labeled alternative in {@link QuizzParser#cycle}.
	 * @param ctx the parse tree
	 */
	void exitTableIteration(QuizzParser.TableIterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(QuizzParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(QuizzParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizzParser#breakOperation}.
	 * @param ctx the parse tree
	 */
	void enterBreakOperation(QuizzParser.BreakOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizzParser#breakOperation}.
	 * @param ctx the parse tree
	 */
	void exitBreakOperation(QuizzParser.BreakOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Item}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterItem(QuizzParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Item}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitItem(QuizzParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(QuizzParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(QuizzParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exponent}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterExponent(QuizzParser.ExponentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exponent}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitExponent(QuizzParser.ExponentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisOper}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisOper(QuizzParser.ParenthesisOperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisOper}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisOper(QuizzParser.ParenthesisOperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SignOper}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterSignOper(QuizzParser.SignOperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SignOper}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitSignOper(QuizzParser.SignOperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubtract}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterAddSubtract(QuizzParser.AddSubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubtract}
	 * labeled alternative in {@link QuizzParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitAddSubtract(QuizzParser.AddSubtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarComp}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterVarComp(QuizzParser.VarCompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarComp}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitVarComp(QuizzParser.VarCompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterNotCond(QuizzParser.NotCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitNotCond(QuizzParser.NotCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondComp}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterCondComp(QuizzParser.CondCompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondComp}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitCondComp(QuizzParser.CondCompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisCond}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisCond(QuizzParser.ParenthesisCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisCond}
	 * labeled alternative in {@link QuizzParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisCond(QuizzParser.ParenthesisCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleId}
	 * labeled alternative in {@link QuizzParser#methods}.
	 * @param ctx the parse tree
	 */
	void enterSingleId(QuizzParser.SingleIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleId}
	 * labeled alternative in {@link QuizzParser#methods}.
	 * @param ctx the parse tree
	 */
	void exitSingleId(QuizzParser.SingleIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Method}
	 * labeled alternative in {@link QuizzParser#methods}.
	 * @param ctx the parse tree
	 */
	void enterMethod(QuizzParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Method}
	 * labeled alternative in {@link QuizzParser#methods}.
	 * @param ctx the parse tree
	 */
	void exitMethod(QuizzParser.MethodContext ctx);
}