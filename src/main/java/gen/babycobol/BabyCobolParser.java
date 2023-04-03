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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, VAR=17, 
		INT=18, WS=19, DOT=20;
	public static final int
		RULE_program = 0, RULE_sentence = 1, RULE_procname = 2, RULE_statement = 3, 
		RULE_accept = 4, RULE_add = 5, RULE_subtract = 6, RULE_divide = 7, RULE_multiply = 8, 
		RULE_giving = 9, RULE_display = 10, RULE_withnoadvancing = 11, RULE_stop = 12, 
		RULE_perform = 13, RULE_remainder = 14, RULE_when = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "sentence", "procname", "statement", "accept", "add", "subtract", 
			"divide", "multiply", "giving", "display", "withnoadvancing", "stop", 
			"perform", "remainder", "when"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ACCEPT'", "'ADD'", "'TO'", "'SUBTRACT'", "'FROM'", "'DIVIDE'", 
			"'INTO'", "'MULTIPLY'", "'BY'", "'GIVING'", "'DISPLAY'", "'WITH NO ADVANCING'", 
			"'STOP'", "'PERFORM'", "'REMAINDER'", "'WHEN'", null, null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "VAR", "INT", "WS", "DOT"
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
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				sentence();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 158038L) != 0 );
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
	public static class SentenceContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(BabyCobolParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(BabyCobolParser.DOT, i);
		}
		public ProcnameContext procname() {
			return getRuleContext(ProcnameContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(37);
				procname();
				setState(38);
				match(DOT);
				}
			}

			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				statement();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 26966L) != 0 );
			setState(47);
			match(DOT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProcnameContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BabyCobolParser.VAR, 0); }
		public ProcnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterProcname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitProcname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitProcname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcnameContext procname() throws RecognitionException {
		ProcnameContext _localctx = new ProcnameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_procname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
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
	public static class StatementContext extends ParserRuleContext {
		public AcceptContext accept() {
			return getRuleContext(AcceptContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public SubtractContext subtract() {
			return getRuleContext(SubtractContext.class,0);
		}
		public PerformContext perform() {
			return getRuleContext(PerformContext.class,0);
		}
		public DisplayContext display() {
			return getRuleContext(DisplayContext.class,0);
		}
		public StopContext stop() {
			return getRuleContext(StopContext.class,0);
		}
		public DivideContext divide() {
			return getRuleContext(DivideContext.class,0);
		}
		public MultiplyContext multiply() {
			return getRuleContext(MultiplyContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				accept();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				add();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				subtract();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				perform();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				display();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				stop();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 7);
				{
				setState(57);
				divide();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 8);
				{
				setState(58);
				multiply();
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
		enterRule(_localctx, 8, RULE_accept);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__0);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				match(VAR);
				}
				}
				setState(65); 
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
		enterRule(_localctx, 10, RULE_add);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(T__1);
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(68);
					match(INT);
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(73);
				match(T__2);
				setState(74);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__1);
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					match(INT);
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(81);
				match(T__2);
				setState(82);
				match(INT);
				setState(83);
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
		enterRule(_localctx, 12, RULE_subtract);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__3);
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(87);
					match(INT);
					}
					}
					setState(90); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(92);
				match(T__4);
				setState(93);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(T__3);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					match(INT);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(100);
				match(T__4);
				setState(101);
				match(INT);
				setState(102);
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
	public static class DivideContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(BabyCobolParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BabyCobolParser.INT, i);
		}
		public List<TerminalNode> VAR() { return getTokens(BabyCobolParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(BabyCobolParser.VAR, i);
		}
		public GivingContext giving() {
			return getRuleContext(GivingContext.class,0);
		}
		public RemainderContext remainder() {
			return getRuleContext(RemainderContext.class,0);
		}
		public DivideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivideContext divide() throws RecognitionException {
		DivideContext _localctx = new DivideContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_divide);
		int _la;
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__5);
				setState(106);
				match(INT);
				setState(107);
				match(T__6);
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(108);
					match(VAR);
					}
					}
					setState(111); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VAR );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(T__5);
				setState(114);
				match(INT);
				setState(115);
				match(T__6);
				setState(116);
				match(INT);
				setState(117);
				giving();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(T__5);
				setState(119);
				match(INT);
				setState(120);
				match(T__6);
				setState(121);
				match(INT);
				setState(122);
				giving();
				setState(123);
				remainder();
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
	public static class MultiplyContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(BabyCobolParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BabyCobolParser.INT, i);
		}
		public List<TerminalNode> VAR() { return getTokens(BabyCobolParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(BabyCobolParser.VAR, i);
		}
		public GivingContext giving() {
			return getRuleContext(GivingContext.class,0);
		}
		public MultiplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiply);
		int _la;
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(T__7);
				setState(128);
				match(INT);
				setState(129);
				match(T__8);
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(130);
					match(VAR);
					}
					}
					setState(133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VAR );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(T__7);
				setState(136);
				match(INT);
				setState(137);
				match(T__8);
				setState(138);
				match(INT);
				setState(139);
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
		enterRule(_localctx, 18, RULE_giving);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__9);
			setState(143);
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
		public WithnoadvancingContext withnoadvancing() {
			return getRuleContext(WithnoadvancingContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(BabyCobolParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BabyCobolParser.INT, i);
		}
		public List<TerminalNode> VAR() { return getTokens(BabyCobolParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(BabyCobolParser.VAR, i);
		}
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
		enterRule(_localctx, 20, RULE_display);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__10);
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				_la = _input.LA(1);
				if ( !(_la==VAR || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==INT );
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(151);
				withnoadvancing();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class WithnoadvancingContext extends ParserRuleContext {
		public WithnoadvancingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withnoadvancing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterWithnoadvancing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitWithnoadvancing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitWithnoadvancing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithnoadvancingContext withnoadvancing() throws RecognitionException {
		WithnoadvancingContext _localctx = new WithnoadvancingContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_withnoadvancing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__11);
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
		enterRule(_localctx, 24, RULE_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__12);
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
	public static class PerformContext extends ParserRuleContext {
		public ProcnameContext procname() {
			return getRuleContext(ProcnameContext.class,0);
		}
		public PerformContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perform; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterPerform(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitPerform(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitPerform(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerformContext perform() throws RecognitionException {
		PerformContext _localctx = new PerformContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_perform);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__13);
			setState(159);
			procname();
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
	public static class RemainderContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BabyCobolParser.VAR, 0); }
		public RemainderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remainder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterRemainder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitRemainder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitRemainder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemainderContext remainder() throws RecognitionException {
		RemainderContext _localctx = new RemainderContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_remainder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__14);
			setState(162);
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
	public static class WhenContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).enterWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyCobolListener ) ((BabyCobolListener)listener).exitWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyCobolVisitor ) return ((BabyCobolVisitor<? extends T>)visitor).visitWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenContext when() throws RecognitionException {
		WhenContext _localctx = new WhenContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_when);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__15);
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				statement();
				}
				}
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 26966L) != 0 );
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
		"\u0004\u0001\u0014\u00ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000\f\u0000#\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001)\b\u0001\u0001\u0001\u0004\u0001"+
		",\b\u0001\u000b\u0001\f\u0001-\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003<\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0004\u0004@\b\u0004\u000b\u0004\f\u0004A\u0001\u0005\u0001\u0005"+
		"\u0004\u0005F\b\u0005\u000b\u0005\f\u0005G\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005N\b\u0005\u000b\u0005\f\u0005O\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005U\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0004\u0006Y\b\u0006\u000b\u0006\f\u0006Z\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006a\b\u0006\u000b\u0006\f\u0006b\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006h\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0004\u0007n\b\u0007\u000b\u0007\f\u0007o\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007~\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0084\b\b\u000b"+
		"\b\f\b\u0085\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u008d\b\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0004\n\u0094\b\n\u000b\n\f\n"+
		"\u0095\u0001\n\u0003\n\u0099\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0004\u000f\u00a7\b\u000f\u000b\u000f\f\u000f\u00a8\u0001"+
		"\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0001\u0001\u0000\u0011\u0012"+
		"\u00b3\u0000!\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004"+
		"1\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\b=\u0001\u0000"+
		"\u0000\u0000\nT\u0001\u0000\u0000\u0000\fg\u0001\u0000\u0000\u0000\u000e"+
		"}\u0001\u0000\u0000\u0000\u0010\u008c\u0001\u0000\u0000\u0000\u0012\u008e"+
		"\u0001\u0000\u0000\u0000\u0014\u0091\u0001\u0000\u0000\u0000\u0016\u009a"+
		"\u0001\u0000\u0000\u0000\u0018\u009c\u0001\u0000\u0000\u0000\u001a\u009e"+
		"\u0001\u0000\u0000\u0000\u001c\u00a1\u0001\u0000\u0000\u0000\u001e\u00a4"+
		"\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000"+
		"\u0000\"#\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$\u0001\u0001\u0000\u0000\u0000%&\u0003\u0004\u0002\u0000"+
		"&\'\u0005\u0014\u0000\u0000\')\u0001\u0000\u0000\u0000(%\u0001\u0000\u0000"+
		"\u0000()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*,\u0003\u0006"+
		"\u0003\u0000+*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001"+
		"\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/0\u0005\u0014\u0000\u00000\u0003\u0001\u0000\u0000\u000012\u0005\u0011"+
		"\u0000\u00002\u0005\u0001\u0000\u0000\u00003<\u0003\b\u0004\u00004<\u0003"+
		"\n\u0005\u00005<\u0003\f\u0006\u00006<\u0003\u001a\r\u00007<\u0003\u0014"+
		"\n\u00008<\u0003\u0018\f\u00009<\u0003\u000e\u0007\u0000:<\u0003\u0010"+
		"\b\u0000;3\u0001\u0000\u0000\u0000;4\u0001\u0000\u0000\u0000;5\u0001\u0000"+
		"\u0000\u0000;6\u0001\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000;8\u0001"+
		"\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;:\u0001\u0000\u0000\u0000"+
		"<\u0007\u0001\u0000\u0000\u0000=?\u0005\u0001\u0000\u0000>@\u0005\u0011"+
		"\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\t\u0001\u0000\u0000\u0000"+
		"CE\u0005\u0002\u0000\u0000DF\u0005\u0012\u0000\u0000ED\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005\u0003\u0000\u0000JU\u0005"+
		"\u0011\u0000\u0000KM\u0005\u0002\u0000\u0000LN\u0005\u0012\u0000\u0000"+
		"ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0005\u0003"+
		"\u0000\u0000RS\u0005\u0012\u0000\u0000SU\u0003\u0012\t\u0000TC\u0001\u0000"+
		"\u0000\u0000TK\u0001\u0000\u0000\u0000U\u000b\u0001\u0000\u0000\u0000"+
		"VX\u0005\u0004\u0000\u0000WY\u0005\u0012\u0000\u0000XW\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0005\u0005\u0000\u0000]h\u0005"+
		"\u0011\u0000\u0000^`\u0005\u0004\u0000\u0000_a\u0005\u0012\u0000\u0000"+
		"`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0005\u0005"+
		"\u0000\u0000ef\u0005\u0012\u0000\u0000fh\u0003\u0012\t\u0000gV\u0001\u0000"+
		"\u0000\u0000g^\u0001\u0000\u0000\u0000h\r\u0001\u0000\u0000\u0000ij\u0005"+
		"\u0006\u0000\u0000jk\u0005\u0012\u0000\u0000km\u0005\u0007\u0000\u0000"+
		"ln\u0005\u0011\u0000\u0000ml\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p~\u0001\u0000"+
		"\u0000\u0000qr\u0005\u0006\u0000\u0000rs\u0005\u0012\u0000\u0000st\u0005"+
		"\u0007\u0000\u0000tu\u0005\u0012\u0000\u0000u~\u0003\u0012\t\u0000vw\u0005"+
		"\u0006\u0000\u0000wx\u0005\u0012\u0000\u0000xy\u0005\u0007\u0000\u0000"+
		"yz\u0005\u0012\u0000\u0000z{\u0003\u0012\t\u0000{|\u0003\u001c\u000e\u0000"+
		"|~\u0001\u0000\u0000\u0000}i\u0001\u0000\u0000\u0000}q\u0001\u0000\u0000"+
		"\u0000}v\u0001\u0000\u0000\u0000~\u000f\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005\b\u0000\u0000\u0080\u0081\u0005\u0012\u0000\u0000\u0081\u0083"+
		"\u0005\t\u0000\u0000\u0082\u0084\u0005\u0011\u0000\u0000\u0083\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u008d\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005\b\u0000\u0000\u0088\u0089\u0005\u0012"+
		"\u0000\u0000\u0089\u008a\u0005\t\u0000\u0000\u008a\u008b\u0005\u0012\u0000"+
		"\u0000\u008b\u008d\u0003\u0012\t\u0000\u008c\u007f\u0001\u0000\u0000\u0000"+
		"\u008c\u0087\u0001\u0000\u0000\u0000\u008d\u0011\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0005\n\u0000\u0000\u008f\u0090\u0005\u0011\u0000\u0000\u0090"+
		"\u0013\u0001\u0000\u0000\u0000\u0091\u0093\u0005\u000b\u0000\u0000\u0092"+
		"\u0094\u0007\u0000\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097"+
		"\u0099\u0003\u0016\u000b\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u0015\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005\f\u0000\u0000\u009b\u0017\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0005\r\u0000\u0000\u009d\u0019\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"\u000e\u0000\u0000\u009f\u00a0\u0003\u0004\u0002\u0000\u00a0\u001b\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0005\u000f\u0000\u0000\u00a2\u00a3\u0005"+
		"\u0011\u0000\u0000\u00a3\u001d\u0001\u0000\u0000\u0000\u00a4\u00a6\u0005"+
		"\u0010\u0000\u0000\u00a5\u00a7\u0003\u0006\u0003\u0000\u00a6\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u001f\u0001"+
		"\u0000\u0000\u0000\u0012#(-;AGOTZbgo}\u0085\u008c\u0095\u0098\u00a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}