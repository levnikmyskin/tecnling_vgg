// Generated from DslTest.g4 by ANTLR 4.7.1
package tecnling.euporia.restful.euporiarestful.dsl.dsltest;// Generated from DslTest.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DslTestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SENTENCE=9, 
		WORDS=10;
	public static final int
		RULE_taggedSentence = 0, RULE_tag = 1, RULE_mf = 2, RULE_sml = 3, RULE_firstTerm = 4, 
		RULE_secondTerm = 5, RULE_anf = 6, RULE_endmf = 7, RULE_endsml = 8, RULE_endanf = 9;
	public static final String[] ruleNames = {
		"taggedSentence", "tag", "mf", "sml", "firstTerm", "secondTerm", "anf", 
		"endmf", "endsml", "endanf"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<mf>'", "'<sml>'", "'#1'", "'#2'", "'<anf>'", "'</mf>'", "'</sml>'", 
		"'</anf>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "SENTENCE", "WORDS"
	};
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
	public String getGrammarFileName() { return "DslTest.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DslTestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TaggedSentenceContext extends ParserRuleContext {
		public List<TagContext> tag() {
			return getRuleContexts(TagContext.class);
		}
		public TagContext tag(int i) {
			return getRuleContext(TagContext.class,i);
		}
		public TaggedSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taggedSentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterTaggedSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitTaggedSentence(this);
		}
	}

	public final TaggedSentenceContext taggedSentence() throws RecognitionException {
		TaggedSentenceContext _localctx = new TaggedSentenceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_taggedSentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				tag();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4))) != 0) );
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

	public static class TagContext extends ParserRuleContext {
		public MfContext mf() {
			return getRuleContext(MfContext.class,0);
		}
		public SmlContext sml() {
			return getRuleContext(SmlContext.class,0);
		}
		public AnfContext anf() {
			return getRuleContext(AnfContext.class,0);
		}
		public EndmfContext endmf() {
			return getRuleContext(EndmfContext.class,0);
		}
		public EndsmlContext endsml() {
			return getRuleContext(EndsmlContext.class,0);
		}
		public EndanfContext endanf() {
			return getRuleContext(EndanfContext.class,0);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitTag(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(25);
				mf();
				}
				break;
			case T__1:
				{
				setState(26);
				sml();
				}
				break;
			case T__4:
				{
				setState(27);
				anf();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(30);
				endmf();
				}
				break;
			case T__6:
				{
				setState(31);
				endsml();
				}
				break;
			case T__7:
				{
				setState(32);
				endanf();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class MfContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(DslTestParser.SENTENCE, 0); }
		public MfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterMf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitMf(this);
		}
	}

	public final MfContext mf() throws RecognitionException {
		MfContext _localctx = new MfContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__0);
			setState(36);
			match(SENTENCE);
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

	public static class SmlContext extends ParserRuleContext {
		public List<TerminalNode> SENTENCE() { return getTokens(DslTestParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(DslTestParser.SENTENCE, i);
		}
		public FirstTermContext firstTerm() {
			return getRuleContext(FirstTermContext.class,0);
		}
		public SecondTermContext secondTerm() {
			return getRuleContext(SecondTermContext.class,0);
		}
		public SmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterSml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitSml(this);
		}
	}

	public final SmlContext sml() throws RecognitionException {
		SmlContext _localctx = new SmlContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__1);
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SENTENCE:
				{
				setState(39);
				match(SENTENCE);
				}
				break;
			case T__2:
				{
				setState(40);
				firstTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(43);
				secondTerm();
				}
				break;
			case SENTENCE:
				{
				setState(44);
				match(SENTENCE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FirstTermContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(DslTestParser.SENTENCE, 0); }
		public FirstTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_firstTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterFirstTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitFirstTerm(this);
		}
	}

	public final FirstTermContext firstTerm() throws RecognitionException {
		FirstTermContext _localctx = new FirstTermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_firstTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__2);
			setState(48);
			match(SENTENCE);
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

	public static class SecondTermContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(DslTestParser.SENTENCE, 0); }
		public SecondTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secondTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterSecondTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitSecondTerm(this);
		}
	}

	public final SecondTermContext secondTerm() throws RecognitionException {
		SecondTermContext _localctx = new SecondTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_secondTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__3);
			setState(51);
			match(SENTENCE);
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

	public static class AnfContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(DslTestParser.SENTENCE, 0); }
		public AnfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterAnf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitAnf(this);
		}
	}

	public final AnfContext anf() throws RecognitionException {
		AnfContext _localctx = new AnfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_anf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__4);
			setState(54);
			match(SENTENCE);
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

	public static class EndmfContext extends ParserRuleContext {
		public EndmfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endmf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterEndmf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitEndmf(this);
		}
	}

	public final EndmfContext endmf() throws RecognitionException {
		EndmfContext _localctx = new EndmfContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_endmf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__5);
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

	public static class EndsmlContext extends ParserRuleContext {
		public EndsmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endsml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterEndsml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitEndsml(this);
		}
	}

	public final EndsmlContext endsml() throws RecognitionException {
		EndsmlContext _localctx = new EndsmlContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_endsml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__6);
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

	public static class EndanfContext extends ParserRuleContext {
		public EndanfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endanf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).enterEndanf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DslTestListener ) ((DslTestListener)listener).exitEndanf(this);
		}
	}

	public final EndanfContext endanf() throws RecognitionException {
		EndanfContext _localctx = new EndanfContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_endanf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\fA\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\6\2\30\n\2\r\2\16\2\31\3\3\3\3\3\3\5\3\37\n\3\3\3\3\3\3\3\5\3$\n\3"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\5\5,\n\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16"+
		"\20\22\24\2\2\2=\2\27\3\2\2\2\4\36\3\2\2\2\6%\3\2\2\2\b(\3\2\2\2\n\61"+
		"\3\2\2\2\f\64\3\2\2\2\16\67\3\2\2\2\20:\3\2\2\2\22<\3\2\2\2\24>\3\2\2"+
		"\2\26\30\5\4\3\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2"+
		"\2\32\3\3\2\2\2\33\37\5\6\4\2\34\37\5\b\5\2\35\37\5\16\b\2\36\33\3\2\2"+
		"\2\36\34\3\2\2\2\36\35\3\2\2\2\37#\3\2\2\2 $\5\20\t\2!$\5\22\n\2\"$\5"+
		"\24\13\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%&\7\3\2\2&\'\7\13\2"+
		"\2\'\7\3\2\2\2(+\7\4\2\2),\7\13\2\2*,\5\n\6\2+)\3\2\2\2+*\3\2\2\2,/\3"+
		"\2\2\2-\60\5\f\7\2.\60\7\13\2\2/-\3\2\2\2/.\3\2\2\2\60\t\3\2\2\2\61\62"+
		"\7\5\2\2\62\63\7\13\2\2\63\13\3\2\2\2\64\65\7\6\2\2\65\66\7\13\2\2\66"+
		"\r\3\2\2\2\678\7\7\2\289\7\13\2\29\17\3\2\2\2:;\7\b\2\2;\21\3\2\2\2<="+
		"\7\t\2\2=\23\3\2\2\2>?\7\n\2\2?\25\3\2\2\2\7\31\36#+/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}