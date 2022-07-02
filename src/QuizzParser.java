// Generated from Quizz.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuizzParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		BreakOperator=46, VarType=47, ID=48, String=49, Int=50, Double=51, MethodTypes=52, 
		WS=53, LINE_COMMENT=54, FULL_COMMENT=55, NEWLINE=56;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_quiz = 4, RULE_question = 5, RULE_text = 6, RULE_number = 7, RULE_table = 8, 
		RULE_bquest = 9, RULE_value = 10, RULE_type = 11, RULE_attribute = 12, 
		RULE_shuffle = 13, RULE_input = 14, RULE_output = 15, RULE_cycle = 16, 
		RULE_condition = 17, RULE_breakOperation = 18, RULE_operation = 19, RULE_logic = 20, 
		RULE_methods = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "statement", "assignment", "quiz", "question", "text", 
			"number", "table", "bquest", "value", "type", "attribute", "shuffle", 
			"input", "output", "cycle", "condition", "breakOperation", "operation", 
			"logic", "methods"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'Quiz('", "','", "')'", "'Question('", "'Text('", "'Number('", 
			"'{'", "'}'", "'import('", "'MultipleChoice('", "'Matching('", "'ShortAnswer('", 
			"'NumericAnswer('", "'Essay('", "'Shuffle'", "'['", "']'", "'input('", 
			"'output('", "'for'", "'from'", "'to'", "'do'", "'end'", "'in'", "'if'", 
			"'('", "'+'", "'-'", "'^'", "'*'", "'/'", "'%'", "'//'", "'not'", "'and'", 
			"'or'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'contains'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "BreakOperator", 
			"VarType", "ID", "String", "Int", "Double", "MethodTypes", "WS", "LINE_COMMENT", 
			"FULL_COMMENT", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Quizz.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuizzParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(QuizzParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << BreakOperator) | (1L << VarType) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
				{
				{
				setState(44);
				statement();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public VType tp;
		public String var = null;
		public MethodsContext methods;
		public OperationContext operation;
		public AttributeContext attribute;
		public MethodsContext methods() {
			return getRuleContext(MethodsContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				((ExprContext)_localctx).methods = methods(0);
				((ExprContext)_localctx).tp =  ((ExprContext)_localctx).methods.tp;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				((ExprContext)_localctx).operation = operation(0);
				((ExprContext)_localctx).tp =  ((ExprContext)_localctx).operation.tp;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				((ExprContext)_localctx).attribute = attribute();
				((ExprContext)_localctx).tp =  ((ExprContext)_localctx).attribute.tp;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CycleContext cycle() {
			return getRuleContext(CycleContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public BreakOperationContext breakOperation() {
			return getRuleContext(BreakOperationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				cycle();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				condition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				output();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				breakOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclAssignContext extends AssignmentContext {
		public TerminalNode VarType() { return getToken(QuizzParser.VarType, 0); }
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterDeclAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitDeclAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitDeclAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclContext extends AssignmentContext {
		public TerminalNode VarType() { return getToken(QuizzParser.VarType, 0); }
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public DeclContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(VarType);
				setState(72);
				match(ID);
				setState(73);
				match(T__0);
				setState(74);
				expr();
				}
				break;
			case 2:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(ID);
				setState(76);
				match(T__0);
				setState(77);
				expr();
				}
				break;
			case 3:
				_localctx = new DeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(VarType);
				setState(79);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuizContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public QuizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterQuiz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitQuiz(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitQuiz(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuizContext quiz() throws RecognitionException {
		QuizContext _localctx = new QuizContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quiz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__1);
			setState(83);
			expr();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(84);
				match(T__2);
				setState(85);
				expr();
				}
			}

			setState(88);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__4);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
				{
				setState(91);
				expr();
				setState(92);
				match(T__2);
				setState(93);
				expr();
				setState(94);
				match(T__2);
				setState(95);
				expr();
				setState(96);
				match(T__2);
				setState(97);
				expr();
				}
			}

			setState(101);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
	 
		public TextContext() { }
		public void copyFrom(TextContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TextExprContext extends TextContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TextExprContext(TextContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterTextExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitTextExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitTextExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextStringContext extends TextContext {
		public TerminalNode String() { return getToken(QuizzParser.String, 0); }
		public TextStringContext(TextContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterTextString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitTextString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitTextString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_text);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case String:
				_localctx = new TextStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(String);
				}
				break;
			case T__5:
				_localctx = new TextExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__5);
				setState(105);
				expr();
				setState(106);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public VType tp;
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
			this.tp = ctx.tp;
		}
	}
	public static class NumberValueContext extends NumberContext {
		public ValueContext value;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NumberValueContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterNumberValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitNumberValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitNumberValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExprContext extends NumberContext {
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NumberExprContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_number);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Double:
				_localctx = new NumberValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				((NumberValueContext)_localctx).value = value();
				((NumberValueContext)_localctx).tp =  ((NumberValueContext)_localctx).value.tp;
				}
				break;
			case T__6:
				_localctx = new NumberExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(T__6);
				setState(114);
				((NumberExprContext)_localctx).expr = expr();
				setState(115);
				match(T__3);
				((NumberExprContext)_localctx).tp =  ((NumberExprContext)_localctx).expr.tp;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableContext extends ParserRuleContext {
		public TableVType tp = new TableVType();;
		public TerminalNode VarType() { return getToken(QuizzParser.VarType, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_table);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__7);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VarType) {
				{
				setState(121);
				match(VarType);
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(122);
					match(T__2);
					}
				}

				}
			}

			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
				{
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(127);
						expr();
						setState(128);
						match(T__2);
						}
						} 
					}
					setState(134);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(135);
				expr();
				}
			}

			setState(138);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BquestContext extends ParserRuleContext {
		public Token fname;
		public TerminalNode String() { return getToken(QuizzParser.String, 0); }
		public BquestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bquest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterBquest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitBquest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitBquest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BquestContext bquest() throws RecognitionException {
		BquestContext _localctx = new BquestContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bquest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__9);
			setState(141);
			((BquestContext)_localctx).fname = match(String);
			setState(142);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public NumberVType tp;
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
			this.tp = ctx.tp;
		}
	}
	public static class NumDoubleContext extends ValueContext {
		public TerminalNode Double() { return getToken(QuizzParser.Double, 0); }
		public NumDoubleContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterNumDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitNumDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitNumDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumIntContext extends ValueContext {
		public TerminalNode Int() { return getToken(QuizzParser.Int, 0); }
		public NumIntContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterNumInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitNumInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitNumInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
				_localctx = new NumIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(Int);
				((NumIntContext)_localctx).tp =  new IntegerVType();
				}
				break;
			case Double:
				_localctx = new NumDoubleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(Double);
				((NumDoubleContext)_localctx).tp =  new DoubleVType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeVType tp;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
			this.tp = ctx.tp;
		}
	}
	public static class MatchingContext extends TypeContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MatchingContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterMatching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitMatching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitMatching(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultipleChoiceContext extends TypeContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultipleChoiceContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterMultipleChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitMultipleChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitMultipleChoice(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericAnswerContext extends TypeContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NumericAnswerContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterNumericAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitNumericAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitNumericAnswer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShortAnswerContext extends TypeContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ShortAnswerContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterShortAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitShortAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitShortAnswer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EssayContext extends TypeContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EssayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterEssay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitEssay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitEssay(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				_localctx = new MultipleChoiceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(T__10);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
					{
					setState(151);
					expr();
					setState(152);
					match(T__2);
					setState(153);
					expr();
					}
				}

				setState(157);
				match(T__3);
				((MultipleChoiceContext)_localctx).tp =  new MultipleChoiceVType();
				}
				break;
			case T__11:
				_localctx = new MatchingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(T__11);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
					{
					setState(160);
					expr();
					setState(161);
					match(T__2);
					setState(162);
					expr();
					setState(163);
					match(T__2);
					setState(164);
					expr();
					}
				}

				setState(168);
				match(T__3);
				((MatchingContext)_localctx).tp =  new MatchingVType();
				}
				break;
			case T__12:
				_localctx = new ShortAnswerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(T__12);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
					{
					setState(171);
					expr();
					setState(172);
					match(T__2);
					setState(173);
					expr();
					}
				}

				setState(177);
				match(T__3);
				((ShortAnswerContext)_localctx).tp =  new ShortAnswerVType();
				}
				break;
			case T__13:
				_localctx = new NumericAnswerContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				match(T__13);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
					{
					setState(180);
					expr();
					}
				}

				setState(183);
				match(T__3);
				((NumericAnswerContext)_localctx).tp =  new NumericAnswerVType();
				}
				break;
			case T__14:
				_localctx = new EssayContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				match(T__14);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
					{
					setState(186);
					expr();
					}
				}

				setState(189);
				match(T__3);
				((EssayContext)_localctx).tp =  new EssayVType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public VType tp;
		public String var = null;
		public NumberContext number;
		public TableContext table;
		public TypeContext type;
		public ShuffleContext shuffle;
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public BquestContext bquest() {
			return getRuleContext(BquestContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public QuizContext quiz() {
			return getRuleContext(QuizContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ShuffleContext shuffle() {
			return getRuleContext(ShuffleContext.class,0);
		}
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attribute);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				text();
				((AttributeContext)_localctx).tp =  new TextVType();
				}
				break;
			case T__6:
			case Int:
			case Double:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				((AttributeContext)_localctx).number = number();
				((AttributeContext)_localctx).tp =  ((AttributeContext)_localctx).number.tp;
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				((AttributeContext)_localctx).table = table();
				((AttributeContext)_localctx).tp =  ((AttributeContext)_localctx).table.tp;
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				bquest();
				((AttributeContext)_localctx).tp =  new BQuestVType();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				input();
				((AttributeContext)_localctx).tp =  new TextVType();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 6);
				{
				setState(208);
				quiz();
				((AttributeContext)_localctx).tp =  new QuizVType();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 7);
				{
				setState(211);
				question();
				((AttributeContext)_localctx).tp =  new QuestionVType();
				}
				break;
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 8);
				{
				setState(214);
				((AttributeContext)_localctx).type = type();
				((AttributeContext)_localctx).tp =  ((AttributeContext)_localctx).type.tp;
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 9);
				{
				setState(217);
				((AttributeContext)_localctx).shuffle = shuffle();
				((AttributeContext)_localctx).tp =  ((AttributeContext)_localctx).shuffle.tp;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 10);
				{
				setState(220);
				match(ID);
				((AttributeContext)_localctx).tp =  new NoneVType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShuffleContext extends ParserRuleContext {
		public TableVType tp = new TableVType();;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ShuffleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shuffle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterShuffle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitShuffle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitShuffle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShuffleContext shuffle() throws RecognitionException {
		ShuffleContext _localctx = new ShuffleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_shuffle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__15);
			setState(225);
			match(T__16);
			setState(226);
			expr();
			setState(227);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__18);
			setState(230);
			expr();
			setState(231);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__19);
			setState(234);
			expr();
			setState(235);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CycleContext extends ParserRuleContext {
		public CycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycle; }
	 
		public CycleContext() { }
		public void copyFrom(CycleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumericIterationContext extends CycleContext {
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public NumericIterationContext(CycleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterNumericIteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitNumericIteration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitNumericIteration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableIterationContext extends CycleContext {
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TableIterationContext(CycleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterTableIteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitTableIteration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitTableIteration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleContext cycle() throws RecognitionException {
		CycleContext _localctx = new CycleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cycle);
		int _la;
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new NumericIterationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(T__20);
				setState(238);
				match(ID);
				setState(239);
				match(T__21);
				setState(240);
				expr();
				setState(241);
				match(T__22);
				setState(242);
				expr();
				setState(243);
				match(T__23);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << BreakOperator) | (1L << VarType) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
					{
					{
					setState(244);
					statement();
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				match(T__24);
				}
				break;
			case 2:
				_localctx = new TableIterationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				match(T__20);
				setState(253);
				match(ID);
				setState(254);
				match(T__25);
				setState(255);
				expr();
				setState(256);
				match(T__23);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << BreakOperator) | (1L << VarType) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
					{
					{
					setState(257);
					statement();
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(263);
				match(T__24);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__26);
			setState(268);
			logic(0);
			setState(269);
			match(T__23);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << BreakOperator) | (1L << VarType) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
				{
				{
				setState(270);
				statement();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakOperationContext extends ParserRuleContext {
		public TerminalNode BreakOperator() { return getToken(QuizzParser.BreakOperator, 0); }
		public BreakOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterBreakOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitBreakOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitBreakOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakOperationContext breakOperation() throws RecognitionException {
		BreakOperationContext _localctx = new BreakOperationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_breakOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(BreakOperator);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public VType tp = null;
		public String var = null;
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
	 
		public OperationContext() { }
		public void copyFrom(OperationContext ctx) {
			super.copyFrom(ctx);
			this.tp = ctx.tp;
			this.var = ctx.var;
		}
	}
	public static class ItemContext extends OperationContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ItemContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModContext extends OperationContext {
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public MulDivModContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExponentContext extends OperationContext {
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ExponentContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterExponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitExponent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitExponent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisOperContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ParenthesisOperContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterParenthesisOper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitParenthesisOper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitParenthesisOper(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SignOperContext extends OperationContext {
		public Token sign;
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public SignOperContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterSignOper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitSignOper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitSignOper(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubtractContext extends OperationContext {
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public AddSubtractContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterAddSubtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitAddSubtract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitAddSubtract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		return operation(0);
	}

	private OperationContext operation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperationContext _localctx = new OperationContext(_ctx, _parentState);
		OperationContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_operation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				{
				_localctx = new ParenthesisOperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(281);
				match(T__27);
				setState(282);
				operation(0);
				setState(283);
				match(T__3);
				}
				break;
			case T__28:
			case T__29:
				{
				_localctx = new SignOperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				((SignOperContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__28 || _la==T__29) ) {
					((SignOperContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(286);
				operation(5);
				}
				break;
			case T__1:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__18:
			case ID:
			case String:
			case Int:
			case Double:
				{
				_localctx = new ItemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				attribute();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(299);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new ExponentContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(290);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(291);
						((ExponentContext)_localctx).op = match(T__30);
						setState(292);
						operation(4);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(293);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(294);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(295);
						operation(4);
						}
						break;
					case 3:
						{
						_localctx = new AddSubtractContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(296);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(297);
						((AddSubtractContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((AddSubtractContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(298);
						operation(3);
						}
						break;
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicContext extends ParserRuleContext {
		public String var = null;
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
	 
		public LogicContext() { }
		public void copyFrom(LogicContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
		}
	}
	public static class VarCompContext extends LogicContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarCompContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterVarComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitVarComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitVarComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotCondContext extends LogicContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public NotCondContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterNotCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitNotCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitNotCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondCompContext extends LogicContext {
		public Token op;
		public List<LogicContext> logic() {
			return getRuleContexts(LogicContext.class);
		}
		public LogicContext logic(int i) {
			return getRuleContext(LogicContext.class,i);
		}
		public CondCompContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterCondComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitCondComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitCondComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisCondContext extends LogicContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public ParenthesisCondContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterParenthesisCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitParenthesisCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitParenthesisCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		return logic(0);
	}

	private LogicContext logic(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicContext _localctx = new LogicContext(_ctx, _parentState);
		LogicContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_logic, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(305);
				match(T__27);
				setState(306);
				logic(0);
				setState(307);
				match(T__3);
				}
				break;
			case 2:
				{
				_localctx = new NotCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(309);
				match(T__35);
				setState(310);
				logic(3);
				}
				break;
			case 3:
				{
				_localctx = new VarCompContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311);
				expr();
				setState(312);
				((VarCompContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
					((VarCompContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(313);
				expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondCompContext(new LogicContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logic);
					setState(317);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(318);
					((CondCompContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
						((CondCompContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(319);
					logic(3);
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MethodsContext extends ParserRuleContext {
		public VType tp = null;
		public String var = null;
		public MethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methods; }
	 
		public MethodsContext() { }
		public void copyFrom(MethodsContext ctx) {
			super.copyFrom(ctx);
			this.tp = ctx.tp;
			this.var = ctx.var;
		}
	}
	public static class SingleIdContext extends MethodsContext {
		public Token singleId;
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public SingleIdContext(MethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterSingleId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitSingleId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitSingleId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodContext extends MethodsContext {
		public Token name;
		public MethodsContext methods() {
			return getRuleContext(MethodsContext.class,0);
		}
		public TerminalNode MethodTypes() { return getToken(QuizzParser.MethodTypes, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(QuizzParser.ID, 0); }
		public MethodContext(MethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizzListener ) ((QuizzListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizzVisitor ) return ((QuizzVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodsContext methods() throws RecognitionException {
		return methods(0);
	}

	private MethodsContext methods(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MethodsContext _localctx = new MethodsContext(_ctx, _parentState);
		MethodsContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_methods, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleIdContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(326);
			((SingleIdContext)_localctx).singleId = match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MethodContext(new MethodsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_methods);
					setState(328);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(329);
					match(MethodTypes);
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(330);
						((MethodContext)_localctx).name = match(ID);
						}
					}

					setState(333);
					match(T__27);
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << ID) | (1L << String) | (1L << Int) | (1L << Double))) != 0)) {
						{
						setState(339);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(334);
								expr();
								setState(335);
								match(T__2);
								}
								} 
							}
							setState(341);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						}
						setState(342);
						expr();
						}
					}

					setState(345);
					match(T__3);
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 20:
			return logic_sempred((LogicContext)_localctx, predIndex);
		case 21:
			return methods_sempred((MethodsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean operation_sempred(OperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean logic_sempred(LogicContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean methods_sempred(MethodsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u0162\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2"+
		"\16\2\63\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3@\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4H\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"S\n\5\3\6\3\6\3\6\3\6\5\6Y\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7f\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bo\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\ty\n\t\3\n\3\n\3\n\5\n~\n\n\5\n\u0080\n\n\3\n\3\n\3\n\7"+
		"\n\u0085\n\n\f\n\16\n\u0088\13\n\3\n\5\n\u008b\n\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\5\f\u0097\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u009e\n"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a9\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00b2\n\r\3\r\3\r\3\r\3\r\5\r\u00b8\n\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00be\n\r\3\r\3\r\5\r\u00c2\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00e1\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\7\22\u00f8\n\22\f\22\16\22\u00fb\13\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0105\n\22\f\22\16\22\u0108\13\22"+
		"\3\22\3\22\5\22\u010c\n\22\3\23\3\23\3\23\3\23\7\23\u0112\n\23\f\23\16"+
		"\23\u0115\13\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0123\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25"+
		"\u012e\n\25\f\25\16\25\u0131\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u013e\n\26\3\26\3\26\3\26\7\26\u0143\n\26\f"+
		"\26\16\26\u0146\13\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u014e\n\27\3"+
		"\27\3\27\3\27\3\27\7\27\u0154\n\27\f\27\16\27\u0157\13\27\3\27\5\27\u015a"+
		"\n\27\3\27\7\27\u015d\n\27\f\27\16\27\u0160\13\27\3\27\2\5(*,\30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\6\3\2\37 \3\2\"%\3\2)/\3\2"+
		"\'(\2\u0180\2\61\3\2\2\2\4?\3\2\2\2\6G\3\2\2\2\bR\3\2\2\2\nT\3\2\2\2\f"+
		"\\\3\2\2\2\16n\3\2\2\2\20x\3\2\2\2\22z\3\2\2\2\24\u008e\3\2\2\2\26\u0096"+
		"\3\2\2\2\30\u00c1\3\2\2\2\32\u00e0\3\2\2\2\34\u00e2\3\2\2\2\36\u00e7\3"+
		"\2\2\2 \u00eb\3\2\2\2\"\u010b\3\2\2\2$\u010d\3\2\2\2&\u0118\3\2\2\2(\u0122"+
		"\3\2\2\2*\u013d\3\2\2\2,\u0147\3\2\2\2.\60\5\6\4\2/.\3\2\2\2\60\63\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\2\2"+
		"\3\65\3\3\2\2\2\66\67\5,\27\2\678\b\3\1\28@\3\2\2\29:\5(\25\2:;\b\3\1"+
		"\2;@\3\2\2\2<=\5\32\16\2=>\b\3\1\2>@\3\2\2\2?\66\3\2\2\2?9\3\2\2\2?<\3"+
		"\2\2\2@\5\3\2\2\2AH\5\b\5\2BH\5\"\22\2CH\5$\23\2DH\5\4\3\2EH\5 \21\2F"+
		"H\5&\24\2GA\3\2\2\2GB\3\2\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2"+
		"H\7\3\2\2\2IJ\7\61\2\2JK\7\62\2\2KL\7\3\2\2LS\5\4\3\2MN\7\62\2\2NO\7\3"+
		"\2\2OS\5\4\3\2PQ\7\61\2\2QS\7\62\2\2RI\3\2\2\2RM\3\2\2\2RP\3\2\2\2S\t"+
		"\3\2\2\2TU\7\4\2\2UX\5\4\3\2VW\7\5\2\2WY\5\4\3\2XV\3\2\2\2XY\3\2\2\2Y"+
		"Z\3\2\2\2Z[\7\6\2\2[\13\3\2\2\2\\e\7\7\2\2]^\5\4\3\2^_\7\5\2\2_`\5\4\3"+
		"\2`a\7\5\2\2ab\5\4\3\2bc\7\5\2\2cd\5\4\3\2df\3\2\2\2e]\3\2\2\2ef\3\2\2"+
		"\2fg\3\2\2\2gh\7\6\2\2h\r\3\2\2\2io\7\63\2\2jk\7\b\2\2kl\5\4\3\2lm\7\6"+
		"\2\2mo\3\2\2\2ni\3\2\2\2nj\3\2\2\2o\17\3\2\2\2pq\5\26\f\2qr\b\t\1\2ry"+
		"\3\2\2\2st\7\t\2\2tu\5\4\3\2uv\7\6\2\2vw\b\t\1\2wy\3\2\2\2xp\3\2\2\2x"+
		"s\3\2\2\2y\21\3\2\2\2z\177\7\n\2\2{}\7\61\2\2|~\7\5\2\2}|\3\2\2\2}~\3"+
		"\2\2\2~\u0080\3\2\2\2\177{\3\2\2\2\177\u0080\3\2\2\2\u0080\u008a\3\2\2"+
		"\2\u0081\u0082\5\4\3\2\u0082\u0083\7\5\2\2\u0083\u0085\3\2\2\2\u0084\u0081"+
		"\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\5\4\3\2\u008a\u0086\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\13\2\2\u008d"+
		"\23\3\2\2\2\u008e\u008f\7\f\2\2\u008f\u0090\7\63\2\2\u0090\u0091\7\6\2"+
		"\2\u0091\25\3\2\2\2\u0092\u0093\7\64\2\2\u0093\u0097\b\f\1\2\u0094\u0095"+
		"\7\65\2\2\u0095\u0097\b\f\1\2\u0096\u0092\3\2\2\2\u0096\u0094\3\2\2\2"+
		"\u0097\27\3\2\2\2\u0098\u009d\7\r\2\2\u0099\u009a\5\4\3\2\u009a\u009b"+
		"\7\5\2\2\u009b\u009c\5\4\3\2\u009c\u009e\3\2\2\2\u009d\u0099\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7\6\2\2\u00a0\u00c2\b\r"+
		"\1\2\u00a1\u00a8\7\16\2\2\u00a2\u00a3\5\4\3\2\u00a3\u00a4\7\5\2\2\u00a4"+
		"\u00a5\5\4\3\2\u00a5\u00a6\7\5\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a9\3\2"+
		"\2\2\u00a8\u00a2\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\7\6\2\2\u00ab\u00c2\b\r\1\2\u00ac\u00b1\7\17\2\2\u00ad\u00ae\5"+
		"\4\3\2\u00ae\u00af\7\5\2\2\u00af\u00b0\5\4\3\2\u00b0\u00b2\3\2\2\2\u00b1"+
		"\u00ad\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\6"+
		"\2\2\u00b4\u00c2\b\r\1\2\u00b5\u00b7\7\20\2\2\u00b6\u00b8\5\4\3\2\u00b7"+
		"\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7\6"+
		"\2\2\u00ba\u00c2\b\r\1\2\u00bb\u00bd\7\21\2\2\u00bc\u00be\5\4\3\2\u00bd"+
		"\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\6"+
		"\2\2\u00c0\u00c2\b\r\1\2\u00c1\u0098\3\2\2\2\u00c1\u00a1\3\2\2\2\u00c1"+
		"\u00ac\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c2\31\3\2\2"+
		"\2\u00c3\u00c4\5\16\b\2\u00c4\u00c5\b\16\1\2\u00c5\u00e1\3\2\2\2\u00c6"+
		"\u00c7\5\20\t\2\u00c7\u00c8\b\16\1\2\u00c8\u00e1\3\2\2\2\u00c9\u00ca\5"+
		"\22\n\2\u00ca\u00cb\b\16\1\2\u00cb\u00e1\3\2\2\2\u00cc\u00cd\5\24\13\2"+
		"\u00cd\u00ce\b\16\1\2\u00ce\u00e1\3\2\2\2\u00cf\u00d0\5\36\20\2\u00d0"+
		"\u00d1\b\16\1\2\u00d1\u00e1\3\2\2\2\u00d2\u00d3\5\n\6\2\u00d3\u00d4\b"+
		"\16\1\2\u00d4\u00e1\3\2\2\2\u00d5\u00d6\5\f\7\2\u00d6\u00d7\b\16\1\2\u00d7"+
		"\u00e1\3\2\2\2\u00d8\u00d9\5\30\r\2\u00d9\u00da\b\16\1\2\u00da\u00e1\3"+
		"\2\2\2\u00db\u00dc\5\34\17\2\u00dc\u00dd\b\16\1\2\u00dd\u00e1\3\2\2\2"+
		"\u00de\u00df\7\62\2\2\u00df\u00e1\b\16\1\2\u00e0\u00c3\3\2\2\2\u00e0\u00c6"+
		"\3\2\2\2\u00e0\u00c9\3\2\2\2\u00e0\u00cc\3\2\2\2\u00e0\u00cf\3\2\2\2\u00e0"+
		"\u00d2\3\2\2\2\u00e0\u00d5\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00db\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\33\3\2\2\2\u00e2\u00e3\7\22\2\2\u00e3\u00e4"+
		"\7\23\2\2\u00e4\u00e5\5\4\3\2\u00e5\u00e6\7\24\2\2\u00e6\35\3\2\2\2\u00e7"+
		"\u00e8\7\25\2\2\u00e8\u00e9\5\4\3\2\u00e9\u00ea\7\6\2\2\u00ea\37\3\2\2"+
		"\2\u00eb\u00ec\7\26\2\2\u00ec\u00ed\5\4\3\2\u00ed\u00ee\7\6\2\2\u00ee"+
		"!\3\2\2\2\u00ef\u00f0\7\27\2\2\u00f0\u00f1\7\62\2\2\u00f1\u00f2\7\30\2"+
		"\2\u00f2\u00f3\5\4\3\2\u00f3\u00f4\7\31\2\2\u00f4\u00f5\5\4\3\2\u00f5"+
		"\u00f9\7\32\2\2\u00f6\u00f8\5\6\4\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3"+
		"\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fc\u00fd\7\33\2\2\u00fd\u010c\3\2\2\2\u00fe\u00ff\7"+
		"\27\2\2\u00ff\u0100\7\62\2\2\u0100\u0101\7\34\2\2\u0101\u0102\5\4\3\2"+
		"\u0102\u0106\7\32\2\2\u0103\u0105\5\6\4\2\u0104\u0103\3\2\2\2\u0105\u0108"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0109\u010a\7\33\2\2\u010a\u010c\3\2\2\2\u010b\u00ef\3"+
		"\2\2\2\u010b\u00fe\3\2\2\2\u010c#\3\2\2\2\u010d\u010e\7\35\2\2\u010e\u010f"+
		"\5*\26\2\u010f\u0113\7\32\2\2\u0110\u0112\5\6\4\2\u0111\u0110\3\2\2\2"+
		"\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116"+
		"\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7\33\2\2\u0117%\3\2\2\2\u0118"+
		"\u0119\7\60\2\2\u0119\'\3\2\2\2\u011a\u011b\b\25\1\2\u011b\u011c\7\36"+
		"\2\2\u011c\u011d\5(\25\2\u011d\u011e\7\6\2\2\u011e\u0123\3\2\2\2\u011f"+
		"\u0120\t\2\2\2\u0120\u0123\5(\25\7\u0121\u0123\5\32\16\2\u0122\u011a\3"+
		"\2\2\2\u0122\u011f\3\2\2\2\u0122\u0121\3\2\2\2\u0123\u012f\3\2\2\2\u0124"+
		"\u0125\f\6\2\2\u0125\u0126\7!\2\2\u0126\u012e\5(\25\6\u0127\u0128\f\5"+
		"\2\2\u0128\u0129\t\3\2\2\u0129\u012e\5(\25\6\u012a\u012b\f\4\2\2\u012b"+
		"\u012c\t\2\2\2\u012c\u012e\5(\25\5\u012d\u0124\3\2\2\2\u012d\u0127\3\2"+
		"\2\2\u012d\u012a\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130)\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\b\26\1\2"+
		"\u0133\u0134\7\36\2\2\u0134\u0135\5*\26\2\u0135\u0136\7\6\2\2\u0136\u013e"+
		"\3\2\2\2\u0137\u0138\7&\2\2\u0138\u013e\5*\26\5\u0139\u013a\5\4\3\2\u013a"+
		"\u013b\t\4\2\2\u013b\u013c\5\4\3\2\u013c\u013e\3\2\2\2\u013d\u0132\3\2"+
		"\2\2\u013d\u0137\3\2\2\2\u013d\u0139\3\2\2\2\u013e\u0144\3\2\2\2\u013f"+
		"\u0140\f\4\2\2\u0140\u0141\t\5\2\2\u0141\u0143\5*\26\5\u0142\u013f\3\2"+
		"\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"+\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\b\27\1\2\u0148\u0149\7\62\2"+
		"\2\u0149\u015e\3\2\2\2\u014a\u014b\f\4\2\2\u014b\u014d\7\66\2\2\u014c"+
		"\u014e\7\62\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3"+
		"\2\2\2\u014f\u0159\7\36\2\2\u0150\u0151\5\4\3\2\u0151\u0152\7\5\2\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0150\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u015a\5\4\3\2\u0159\u0155\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u015d\7\6\2\2\u015c\u014a\3\2\2\2\u015d\u0160\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f-\3\2\2\2\u0160\u015e\3\2\2\2"+
		"#\61?GRXenx}\177\u0086\u008a\u0096\u009d\u00a8\u00b1\u00b7\u00bd\u00c1"+
		"\u00e0\u00f9\u0106\u010b\u0113\u0122\u012d\u012f\u013d\u0144\u014d\u0155"+
		"\u0159\u015e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}