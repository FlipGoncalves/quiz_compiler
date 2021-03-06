// Generated from Secondary.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SecondaryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, Dif=12, Int=13, String=14, QUOTE=15, WS=16, LINE_COMMENT=17, 
		FULL_COMMENT=18, NEWLINE=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "Dif", "Int", "String", "QUOTE", "WS", "LINE_COMMENT", 
			"FULL_COMMENT", "NEWLINE"
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


	public SecondaryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Secondary.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\16\6\16m\n\16\r\16\16\16n\3\17\3\17\7\17s\n\17\f\17\16"+
		"\17v\13\17\3\17\3\17\3\20\3\20\3\21\6\21}\n\21\r\21\16\21~\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\7\22\u0087\n\22\f\22\16\22\u008a\13\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u0095\n\23\f\23\16\23\u0098\13"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\5\24\u00a1\n\24\3\24\3\24\3\24"+
		"\3\24\5t\u0088\u0096\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\6\3\2\63\65\3\2\62"+
		";\4\2$$))\5\2\13\f\17\17\"\"\2\u00ab\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2"+
		"\2\2\5+\3\2\2\2\7-\3\2\2\2\t\62\3\2\2\2\13<\3\2\2\2\rH\3\2\2\2\17M\3\2"+
		"\2\2\21\\\3\2\2\2\23^\3\2\2\2\25`\3\2\2\2\27b\3\2\2\2\31i\3\2\2\2\33l"+
		"\3\2\2\2\35p\3\2\2\2\37y\3\2\2\2!|\3\2\2\2#\u0082\3\2\2\2%\u008f\3\2\2"+
		"\2\'\u00a0\3\2\2\2)*\7}\2\2*\4\3\2\2\2+,\7\177\2\2,\6\3\2\2\2-.\7v\2\2"+
		"./\7g\2\2/\60\7o\2\2\60\61\7c\2\2\61\b\3\2\2\2\62\63\7g\2\2\63\64\7p\2"+
		"\2\64\65\7w\2\2\65\66\7p\2\2\66\67\7e\2\2\678\7k\2\289\7c\2\29:\7f\2\2"+
		":;\7q\2\2;\n\3\2\2\2<=\7f\2\2=>\7k\2\2>?\7h\2\2?@\7k\2\2@A\7e\2\2AB\7"+
		"w\2\2BC\7n\2\2CD\7f\2\2DE\7c\2\2EF\7f\2\2FG\7g\2\2G\f\3\2\2\2HI\7v\2\2"+
		"IJ\7k\2\2JK\7r\2\2KL\7q\2\2L\16\3\2\2\2MN\7r\2\2NO\7c\2\2OP\7n\2\2PQ\7"+
		"c\2\2QR\7x\2\2RS\7t\2\2ST\7c\2\2TU\7u\2\2UV\7/\2\2VW\7e\2\2WX\7j\2\2X"+
		"Y\7c\2\2YZ\7x\2\2Z[\7g\2\2[\20\3\2\2\2\\]\7]\2\2]\22\3\2\2\2^_\7.\2\2"+
		"_\24\3\2\2\2`a\7_\2\2a\26\3\2\2\2bc\7q\2\2cd\7r\2\2de\7e\2\2ef\7q\2\2"+
		"fg\7g\2\2gh\7u\2\2h\30\3\2\2\2ij\t\2\2\2j\32\3\2\2\2km\t\3\2\2lk\3\2\2"+
		"\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\34\3\2\2\2pt\5\37\20\2qs\13\2\2\2rq"+
		"\3\2\2\2sv\3\2\2\2tu\3\2\2\2tr\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\5\37\20\2"+
		"x\36\3\2\2\2yz\t\4\2\2z \3\2\2\2{}\t\5\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2"+
		"\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\b\21\2\2\u0081\"\3\2\2\2"+
		"\u0082\u0083\7\61\2\2\u0083\u0084\7\61\2\2\u0084\u0088\3\2\2\2\u0085\u0087"+
		"\13\2\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0088\u0086\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c"+
		"\5\'\24\2\u008c\u008d\3\2\2\2\u008d\u008e\b\22\2\2\u008e$\3\2\2\2\u008f"+
		"\u0090\7\61\2\2\u0090\u0091\7\61\2\2\u0091\u0092\7*\2\2\u0092\u0096\3"+
		"\2\2\2\u0093\u0095\13\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0099\u009a\7+\2\2\u009a\u009b\7\61\2\2\u009b\u009c\7\61\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\b\23\2\2\u009e&\3\2\2\2\u009f\u00a1\7\17\2"+
		"\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\7\f\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\24\2\2\u00a5(\3\2\2\2\t\2n"+
		"t~\u0088\u0096\u00a0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}