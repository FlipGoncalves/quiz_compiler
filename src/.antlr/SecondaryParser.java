// Generated from /home/hugo/Desktop/Faculdade/Segundo Ano/Segundo Semestre/Compiladores/Projeto/quiz-comp-06/src/Secondary.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SecondaryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, Dif=12, Int=13, String=14, QUOTE=15, WS=16, LINE_COMMENT=17, 
		FULL_COMMENT=18, NEWLINE=19;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_question = 2, RULE_pal = 3, RULE_opt = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "question", "pal", "opt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'tema'", "'enunciado'", "'dificuldade'", "'tipo'", 
			"'palavras-chave'", "'['", "','", "']'", "'opcoes'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"Dif", "Int", "String", "QUOTE", "WS", "LINE_COMMENT", "FULL_COMMENT", 
			"NEWLINE"
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
	public String getGrammarFileName() { return "Secondary.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SecondaryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SecondaryParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(10);
				expr();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
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
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__0);
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(19);
				question();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			match(T__1);
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
		public Token theme;
		public Token head;
		public Token diff;
		public Token type;
		public List<TerminalNode> String() { return getTokens(SecondaryParser.String); }
		public TerminalNode String(int i) {
			return getToken(SecondaryParser.String, i);
		}
		public TerminalNode Dif() { return getToken(SecondaryParser.Dif, 0); }
		public List<PalContext> pal() {
			return getRuleContexts(PalContext.class);
		}
		public PalContext pal(int i) {
			return getRuleContext(PalContext.class,i);
		}
		public List<OptContext> opt() {
			return getRuleContexts(OptContext.class);
		}
		public OptContext opt(int i) {
			return getRuleContext(OptContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__0);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(28);
				match(T__2);
				setState(29);
				((QuestionContext)_localctx).theme = match(String);
				}
			}

			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(32);
				match(T__3);
				setState(33);
				((QuestionContext)_localctx).head = match(String);
				}
			}

			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(36);
				match(T__4);
				setState(37);
				((QuestionContext)_localctx).diff = match(Dif);
				}
			}

			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(40);
				match(T__5);
				setState(41);
				((QuestionContext)_localctx).type = match(String);
				}
			}

			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(44);
				match(T__6);
				setState(45);
				match(T__7);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Int || _la==String) {
					{
					setState(46);
					pal();
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(47);
						match(T__8);
						setState(48);
						pal();
						}
						}
						setState(53);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(56);
				match(T__9);
				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(59);
				match(T__10);
				setState(60);
				match(T__0);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7 || _la==String) {
					{
					setState(61);
					opt();
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(62);
						match(T__8);
						setState(63);
						opt();
						}
						}
						setState(68);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(71);
				match(T__1);
				}
			}

			setState(74);
			match(T__1);
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

	public static class PalContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(SecondaryParser.String, 0); }
		public TerminalNode Int() { return getToken(SecondaryParser.Int, 0); }
		public PalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pal; }
	}

	public final PalContext pal() throws RecognitionException {
		PalContext _localctx = new PalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_la = _input.LA(1);
			if ( !(_la==Int || _la==String) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class OptContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(SecondaryParser.String); }
		public TerminalNode String(int i) {
			return getToken(SecondaryParser.String, i);
		}
		public OptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt; }
	}

	public final OptContext opt() throws RecognitionException {
		OptContext _localctx = new OptContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_opt);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(String);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(T__7);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==String) {
					{
					setState(80);
					match(String);
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(81);
						match(T__8);
						setState(82);
						match(String);
						}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(90);
				match(T__9);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25`\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\3\2\3\3"+
		"\3\3\7\3\27\n\3\f\3\16\3\32\13\3\3\3\3\3\3\4\3\4\3\4\5\4!\n\4\3\4\3\4"+
		"\5\4%\n\4\3\4\3\4\5\4)\n\4\3\4\3\4\5\4-\n\4\3\4\3\4\3\4\3\4\3\4\7\4\64"+
		"\n\4\f\4\16\4\67\13\4\5\49\n\4\3\4\5\4<\n\4\3\4\3\4\3\4\3\4\3\4\7\4C\n"+
		"\4\f\4\16\4F\13\4\5\4H\n\4\3\4\5\4K\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\7\6V\n\6\f\6\16\6Y\13\6\5\6[\n\6\3\6\5\6^\n\6\3\6\2\2\7\2\4\6\b"+
		"\n\2\3\3\2\17\20\2i\2\17\3\2\2\2\4\24\3\2\2\2\6\35\3\2\2\2\bN\3\2\2\2"+
		"\n]\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20"+
		"\3\2\2\2\20\22\3\2\2\2\21\17\3\2\2\2\22\23\7\2\2\3\23\3\3\2\2\2\24\30"+
		"\7\3\2\2\25\27\5\6\4\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31"+
		"\3\2\2\2\31\33\3\2\2\2\32\30\3\2\2\2\33\34\7\4\2\2\34\5\3\2\2\2\35 \7"+
		"\3\2\2\36\37\7\5\2\2\37!\7\20\2\2 \36\3\2\2\2 !\3\2\2\2!$\3\2\2\2\"#\7"+
		"\6\2\2#%\7\20\2\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&\'\7\7\2\2\')\7\16\2"+
		"\2(&\3\2\2\2()\3\2\2\2),\3\2\2\2*+\7\b\2\2+-\7\20\2\2,*\3\2\2\2,-\3\2"+
		"\2\2-;\3\2\2\2./\7\t\2\2/8\7\n\2\2\60\65\5\b\5\2\61\62\7\13\2\2\62\64"+
		"\5\b\5\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\669\3"+
		"\2\2\2\67\65\3\2\2\28\60\3\2\2\289\3\2\2\29:\3\2\2\2:<\7\f\2\2;.\3\2\2"+
		"\2;<\3\2\2\2<J\3\2\2\2=>\7\r\2\2>G\7\3\2\2?D\5\n\6\2@A\7\13\2\2AC\5\n"+
		"\6\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2G?\3\2"+
		"\2\2GH\3\2\2\2HI\3\2\2\2IK\7\4\2\2J=\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\4"+
		"\2\2M\7\3\2\2\2NO\t\2\2\2O\t\3\2\2\2P^\7\20\2\2QZ\7\n\2\2RW\7\20\2\2S"+
		"T\7\13\2\2TV\7\20\2\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2"+
		"\2YW\3\2\2\2ZR\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\^\7\f\2\2]P\3\2\2\2]Q\3\2"+
		"\2\2^\13\3\2\2\2\21\17\30 $(,\658;DGJWZ]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}