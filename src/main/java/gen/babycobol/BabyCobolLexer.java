// Generated from java-escape by ANTLR 4.11.1
package gen.babycobol;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BabyCobolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, VAR=11, INT=12, WS=13, DOT=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "VAR", "INT", "WS", "DOT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ACCEPT'", "'ADD'", "'TO'", "'SUBTRACT'", "'FROM'", "'GIVING'", 
			"'DISPLAY'", "'WITH NO ADVANCING'", "'STOP'", "'PERFORM'", null, null, 
			null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "VAR", 
			"INT", "WS", "DOT"
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


	public BabyCobolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BabyCobol.g4"; }

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
		"\u0004\u0000\u000e|\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\nj\b\n\n\n\f\nm\t\n\u0001\u000b"+
		"\u0004\u000bp\b\u000b\u000b\u000b\f\u000bq\u0001\f\u0004\fu\b\f\u000b"+
		"\f\f\fv\u0001\f\u0001\f\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001\u0000"+
		"\u0004\u0002\u0000AZaz\u0004\u0000--09AZaz\u0001\u000009\u0003\u0000\t"+
		"\n\f\r  ~\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0001\u001d\u0001\u0000\u0000\u0000\u0003$\u0001\u0000\u0000\u0000\u0005"+
		"(\u0001\u0000\u0000\u0000\u0007+\u0001\u0000\u0000\u0000\t4\u0001\u0000"+
		"\u0000\u0000\u000b9\u0001\u0000\u0000\u0000\r@\u0001\u0000\u0000\u0000"+
		"\u000fH\u0001\u0000\u0000\u0000\u0011Z\u0001\u0000\u0000\u0000\u0013_"+
		"\u0001\u0000\u0000\u0000\u0015g\u0001\u0000\u0000\u0000\u0017o\u0001\u0000"+
		"\u0000\u0000\u0019t\u0001\u0000\u0000\u0000\u001bz\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005A\u0000\u0000\u001e\u001f\u0005C\u0000\u0000\u001f "+
		"\u0005C\u0000\u0000 !\u0005E\u0000\u0000!\"\u0005P\u0000\u0000\"#\u0005"+
		"T\u0000\u0000#\u0002\u0001\u0000\u0000\u0000$%\u0005A\u0000\u0000%&\u0005"+
		"D\u0000\u0000&\'\u0005D\u0000\u0000\'\u0004\u0001\u0000\u0000\u0000()"+
		"\u0005T\u0000\u0000)*\u0005O\u0000\u0000*\u0006\u0001\u0000\u0000\u0000"+
		"+,\u0005S\u0000\u0000,-\u0005U\u0000\u0000-.\u0005B\u0000\u0000./\u0005"+
		"T\u0000\u0000/0\u0005R\u0000\u000001\u0005A\u0000\u000012\u0005C\u0000"+
		"\u000023\u0005T\u0000\u00003\b\u0001\u0000\u0000\u000045\u0005F\u0000"+
		"\u000056\u0005R\u0000\u000067\u0005O\u0000\u000078\u0005M\u0000\u0000"+
		"8\n\u0001\u0000\u0000\u00009:\u0005G\u0000\u0000:;\u0005I\u0000\u0000"+
		";<\u0005V\u0000\u0000<=\u0005I\u0000\u0000=>\u0005N\u0000\u0000>?\u0005"+
		"G\u0000\u0000?\f\u0001\u0000\u0000\u0000@A\u0005D\u0000\u0000AB\u0005"+
		"I\u0000\u0000BC\u0005S\u0000\u0000CD\u0005P\u0000\u0000DE\u0005L\u0000"+
		"\u0000EF\u0005A\u0000\u0000FG\u0005Y\u0000\u0000G\u000e\u0001\u0000\u0000"+
		"\u0000HI\u0005W\u0000\u0000IJ\u0005I\u0000\u0000JK\u0005T\u0000\u0000"+
		"KL\u0005H\u0000\u0000LM\u0005 \u0000\u0000MN\u0005N\u0000\u0000NO\u0005"+
		"O\u0000\u0000OP\u0005 \u0000\u0000PQ\u0005A\u0000\u0000QR\u0005D\u0000"+
		"\u0000RS\u0005V\u0000\u0000ST\u0005A\u0000\u0000TU\u0005N\u0000\u0000"+
		"UV\u0005C\u0000\u0000VW\u0005I\u0000\u0000WX\u0005N\u0000\u0000XY\u0005"+
		"G\u0000\u0000Y\u0010\u0001\u0000\u0000\u0000Z[\u0005S\u0000\u0000[\\\u0005"+
		"T\u0000\u0000\\]\u0005O\u0000\u0000]^\u0005P\u0000\u0000^\u0012\u0001"+
		"\u0000\u0000\u0000_`\u0005P\u0000\u0000`a\u0005E\u0000\u0000ab\u0005R"+
		"\u0000\u0000bc\u0005F\u0000\u0000cd\u0005O\u0000\u0000de\u0005R\u0000"+
		"\u0000ef\u0005M\u0000\u0000f\u0014\u0001\u0000\u0000\u0000gk\u0007\u0000"+
		"\u0000\u0000hj\u0007\u0001\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000"+
		"l\u0016\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000np\u0007\u0002"+
		"\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u0018\u0001\u0000\u0000"+
		"\u0000su\u0007\u0003\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0006\f\u0000\u0000y\u001a\u0001\u0000\u0000\u0000"+
		"z{\u0005.\u0000\u0000{\u001c\u0001\u0000\u0000\u0000\u0004\u0000kqv\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}