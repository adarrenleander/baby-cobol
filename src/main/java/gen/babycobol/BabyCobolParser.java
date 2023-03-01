// Generated from java-escape by ANTLR 4.11.1
package gen.babycobol;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BabyCobolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, VAR=9, 
		INT=10, WS=11;
	public static final int
		RULE_program = 0, RULE_statements = 1, RULE_accept = 2, RULE_add = 3, 
		RULE_subtract = 4, RULE_giving = 5, RULE_display = 6, RULE_stop = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statements", "accept", "add", "subtract", "giving", "display", 
			"stop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ACCEPT'", "'ADD'", "'TO'", "'SUBTRACT'", "'FROM'", "'GIVING'", 
			"'DISPLAY'", "'STOP'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "VAR", "INT", "WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BabyCobolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				statements();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 406L) != 0 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public AcceptContext accept() {
			return getRuleContext(AcceptContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public SubtractContext subtract() {
			return getRuleContext(SubtractContext.class,0);
		}
		public StopContext stop() {
			return getRuleContext(StopContext.class,0);
		}
		public DisplayContext display() {
			return getRuleContext(DisplayContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				accept();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				add();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				subtract();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(24);
				stop();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(25);
				display();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcceptContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(BabyCobolParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(BabyCobolParser.VAR, i);
		}
		public AcceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterAccept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitAccept(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitAccept(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcceptContext accept() throws RecognitionException {
		AcceptContext _localctx = new AcceptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_accept);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				match(VAR);
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR );
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

	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BabyCobolParser.VAR, 0); }
		public List<TerminalNode> INT() { return getTokens(BabyCobolParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BabyCobolParser.INT, i);
		}
		public GivingContext giving() {
			return getRuleContext(GivingContext.class,0);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_add);
		int _la;
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(T__1);
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(35);
					match(INT);
					}
					}
					setState(38); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(40);
				match(T__2);
				setState(41);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(T__1);
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(43);
					match(INT);
					}
					}
					setState(46); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(48);
				match(T__2);
				setState(49);
				match(INT);
				setState(50);
				giving();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SubtractContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BabyCobolParser.VAR, 0); }
		public List<TerminalNode> INT() { return getTokens(BabyCobolParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BabyCobolParser.INT, i);
		}
		public GivingContext giving() {
			return getRuleContext(GivingContext.class,0);
		}
		public SubtractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtract; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterSubtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitSubtract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitSubtract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractContext subtract() throws RecognitionException {
		SubtractContext _localctx = new SubtractContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_subtract);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__3);
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(54);
					match(INT);
					}
					}
					setState(57); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(59);
				match(T__4);
				setState(60);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(T__3);
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(62);
					match(INT);
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(67);
				match(T__4);
				setState(68);
				match(INT);
				setState(69);
				giving();
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

	@SuppressWarnings("CheckReturnValue")
	public static class GivingContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BabyCobolParser.VAR, 0); }
		public GivingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_giving; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterGiving(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitGiving(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitGiving(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GivingContext giving() throws RecognitionException {
		GivingContext _localctx = new GivingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_giving);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__5);
			setState(73);
			match(VAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DisplayContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BabyCobolParser.INT, 0); }
		public TerminalNode VAR() { return getToken(BabyCobolParser.VAR, 0); }
		public DisplayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_display; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterDisplay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitDisplay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitDisplay(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisplayContext display() throws RecognitionException {
		DisplayContext _localctx = new DisplayContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_display);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(T__6);
				setState(76);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__6);
				setState(78);
				match(VAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StopContext extends ParserRuleContext {
		public StopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterStop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitStop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitStop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StopContext stop() throws RecognitionException {
		StopContext _localctx = new StopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__7);
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
		"\u0004\u0001\u000bT\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0004\u0002\u001f\b\u0002\u000b\u0002\f\u0002"+
		" \u0001\u0003\u0001\u0003\u0004\u0003%\b\u0003\u000b\u0003\f\u0003&\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003-\b\u0003\u000b"+
		"\u0003\f\u0003.\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00034\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0004\u00048\b\u0004\u000b\u0004\f\u00049\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004@\b\u0004\u000b"+
		"\u0004\f\u0004A\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004G\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006P\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000X\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0002\u001a\u0001\u0000\u0000\u0000\u0004"+
		"\u001c\u0001\u0000\u0000\u0000\u00063\u0001\u0000\u0000\u0000\bF\u0001"+
		"\u0000\u0000\u0000\nH\u0001\u0000\u0000\u0000\fO\u0001\u0000\u0000\u0000"+
		"\u000eQ\u0001\u0000\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011"+
		"\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013"+
		"\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014"+
		"\u0001\u0001\u0000\u0000\u0000\u0015\u001b\u0003\u0004\u0002\u0000\u0016"+
		"\u001b\u0003\u0006\u0003\u0000\u0017\u001b\u0003\b\u0004\u0000\u0018\u001b"+
		"\u0003\u000e\u0007\u0000\u0019\u001b\u0003\f\u0006\u0000\u001a\u0015\u0001"+
		"\u0000\u0000\u0000\u001a\u0016\u0001\u0000\u0000\u0000\u001a\u0017\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u0019\u0001"+
		"\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c\u001e\u0005"+
		"\u0001\u0000\u0000\u001d\u001f\u0005\t\u0000\u0000\u001e\u001d\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000"+
		" !\u0001\u0000\u0000\u0000!\u0005\u0001\u0000\u0000\u0000\"$\u0005\u0002"+
		"\u0000\u0000#%\u0005\n\u0000\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000"+
		"\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000()\u0005\u0003\u0000\u0000)4\u0005\t\u0000\u0000*,\u0005"+
		"\u0002\u0000\u0000+-\u0005\n\u0000\u0000,+\u0001\u0000\u0000\u0000-.\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u000001\u0005\u0003\u0000\u000012\u0005\n\u0000\u0000"+
		"24\u0003\n\u0005\u00003\"\u0001\u0000\u0000\u00003*\u0001\u0000\u0000"+
		"\u00004\u0007\u0001\u0000\u0000\u000057\u0005\u0004\u0000\u000068\u0005"+
		"\n\u0000\u000076\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u000097\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";<\u0005\u0005\u0000\u0000<G\u0005\t\u0000\u0000=?\u0005\u0004\u0000\u0000"+
		">@\u0005\n\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CD\u0005\u0005\u0000\u0000DE\u0005\n\u0000\u0000EG\u0003\n\u0005"+
		"\u0000F5\u0001\u0000\u0000\u0000F=\u0001\u0000\u0000\u0000G\t\u0001\u0000"+
		"\u0000\u0000HI\u0005\u0006\u0000\u0000IJ\u0005\t\u0000\u0000J\u000b\u0001"+
		"\u0000\u0000\u0000KL\u0005\u0007\u0000\u0000LP\u0005\n\u0000\u0000MN\u0005"+
		"\u0007\u0000\u0000NP\u0005\t\u0000\u0000OK\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000P\r\u0001\u0000\u0000\u0000QR\u0005\b\u0000\u0000R\u000f"+
		"\u0001\u0000\u0000\u0000\n\u0013\u001a &.39AFO";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}