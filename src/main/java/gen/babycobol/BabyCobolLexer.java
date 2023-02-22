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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, VAR=6, INT=7, WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "VAR", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ACCEPT'", "'ADD'", "'TO'", "'SUBTRACT'", "'FROM'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "VAR", "INT", "WS"
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
		"\u0004\u0000\b@\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0005\u00050\b\u0005\n\u0005\f\u00053\t\u0005\u0001\u0006"+
		"\u0004\u00066\b\u0006\u000b\u0006\f\u00067\u0001\u0007\u0004\u0007;\b"+
		"\u0007\u000b\u0007\f\u0007<\u0001\u0007\u0001\u0007\u0000\u0000\b\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0001\u0000\u0004\u0002\u0000AZaz\u0004\u0000--09AZaz\u0001\u0000"+
		"09\u0003\u0000\t\n\f\r  B\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0001\u0011\u0001\u0000\u0000\u0000\u0003\u0018\u0001\u0000"+
		"\u0000\u0000\u0005\u001c\u0001\u0000\u0000\u0000\u0007\u001f\u0001\u0000"+
		"\u0000\u0000\t(\u0001\u0000\u0000\u0000\u000b-\u0001\u0000\u0000\u0000"+
		"\r5\u0001\u0000\u0000\u0000\u000f:\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0005A\u0000\u0000\u0012\u0013\u0005C\u0000\u0000\u0013\u0014\u0005C"+
		"\u0000\u0000\u0014\u0015\u0005E\u0000\u0000\u0015\u0016\u0005P\u0000\u0000"+
		"\u0016\u0017\u0005T\u0000\u0000\u0017\u0002\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005A\u0000\u0000\u0019\u001a\u0005D\u0000\u0000\u001a\u001b\u0005"+
		"D\u0000\u0000\u001b\u0004\u0001\u0000\u0000\u0000\u001c\u001d\u0005T\u0000"+
		"\u0000\u001d\u001e\u0005O\u0000\u0000\u001e\u0006\u0001\u0000\u0000\u0000"+
		"\u001f \u0005S\u0000\u0000 !\u0005U\u0000\u0000!\"\u0005B\u0000\u0000"+
		"\"#\u0005T\u0000\u0000#$\u0005R\u0000\u0000$%\u0005A\u0000\u0000%&\u0005"+
		"C\u0000\u0000&\'\u0005T\u0000\u0000\'\b\u0001\u0000\u0000\u0000()\u0005"+
		"F\u0000\u0000)*\u0005R\u0000\u0000*+\u0005O\u0000\u0000+,\u0005M\u0000"+
		"\u0000,\n\u0001\u0000\u0000\u0000-1\u0007\u0000\u0000\u0000.0\u0007\u0001"+
		"\u0000\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002\f\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000046\u0007\u0002\u0000\u000054\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u00008\u000e\u0001\u0000\u0000\u00009;\u0007\u0003\u0000\u0000"+
		":9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0006\u0007"+
		"\u0000\u0000?\u0010\u0001\u0000\u0000\u0000\u0004\u000017<\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}