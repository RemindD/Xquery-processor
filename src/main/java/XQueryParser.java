// Generated from /Users/richard/Documents/graduate study/2nd semester/CS232B/project/xquery/src/main/resources/XQuery.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, StringLiteral=36, StringConstant=37, 
		Var=38, WS=39;
	public static final int
		RULE_query = 0, RULE_flwr = 1, RULE_lwr = 2, RULE_letClause = 3, RULE_whereClause = 4, 
		RULE_returnClause = 5, RULE_ap = 6, RULE_rp = 7, RULE_f = 8, RULE_varname = 9, 
		RULE_sentence = 10, RULE_string = 11, RULE_cond = 12;
	public static final String[] ruleNames = {
		"query", "flwr", "lwr", "letClause", "whereClause", "returnClause", "ap", 
		"rp", "f", "varname", "sentence", "string", "cond"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
		"'</'", "'for'", "'in'", "'let'", "':='", "'where'", "'return'", "'doc('", 
		"'document('", "'*'", "'.'", "'..'", "'text()'", "'@'", "'['", "']'", 
		"'='", "'eq'", "'=='", "'is'", "'and'", "'or'", "'not'", "'empty'", "'some'", 
		"'satisfies'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"StringLiteral", "StringConstant", "Var", "WS"
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
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	 
		public QueryContext() { }
		public void copyFrom(QueryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XqapContext extends QueryContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public XqapContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqap(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqtagContext extends QueryContext {
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public XqtagContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqtag(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqconcatContext extends QueryContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public XqconcatContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqconcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqletContext extends QueryContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public XqletContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqlet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqslashContext extends QueryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqslashContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqslash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqparenContext extends QueryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public XqparenContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqparen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqflwrContext extends QueryContext {
		public FlwrContext flwr() {
			return getRuleContext(FlwrContext.class,0);
		}
		public XqflwrContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqflwr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqstringContext extends QueryContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public XqstringContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqstring(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqdoubleslashContext extends QueryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqdoubleslashContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqdoubleslash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqvarContext extends QueryContext {
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public XqvarContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqvar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		return query(0);
	}

	private QueryContext query(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryContext _localctx = new QueryContext(_ctx, _parentState);
		QueryContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_query, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				{
				_localctx = new XqvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(27);
				varname();
				}
				break;
			case StringLiteral:
				{
				_localctx = new XqstringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				sentence();
				}
				break;
			case T__16:
			case T__17:
				{
				_localctx = new XqapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				ap();
				}
				break;
			case T__0:
				{
				_localctx = new XqparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(T__0);
				setState(31);
				query(0);
				setState(32);
				match(T__1);
				}
				break;
			case T__5:
				{
				_localctx = new XqtagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(T__5);
				setState(35);
				string();
				setState(36);
				match(T__6);
				setState(37);
				match(T__7);
				setState(38);
				query(0);
				setState(39);
				match(T__8);
				setState(40);
				match(T__9);
				setState(41);
				string();
				setState(42);
				match(T__6);
				}
				break;
			case T__10:
				{
				_localctx = new XqflwrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(T__10);
				setState(45);
				flwr();
				}
				break;
			case T__12:
				{
				_localctx = new XqletContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				letClause();
				setState(47);
				query(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(60);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new XqconcatContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(51);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(52);
						match(T__2);
						setState(53);
						query(7);
						}
						break;
					case 2:
						{
						_localctx = new XqslashContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(54);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(55);
						match(T__3);
						setState(56);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XqdoubleslashContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(57);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(58);
						match(T__4);
						setState(59);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class FlwrContext extends ParserRuleContext {
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public LwrContext lwr() {
			return getRuleContext(LwrContext.class,0);
		}
		public FlwrContext flwr() {
			return getRuleContext(FlwrContext.class,0);
		}
		public FlwrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFlwr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlwrContext flwr() throws RecognitionException {
		FlwrContext _localctx = new FlwrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_flwr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			varname();
			setState(66);
			match(T__11);
			setState(67);
			query(0);
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__14:
			case T__15:
				{
				setState(68);
				lwr();
				}
				break;
			case T__2:
				{
				{
				setState(69);
				match(T__2);
				setState(70);
				flwr();
				}
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

	public static class LwrContext extends ParserRuleContext {
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public LwrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lwr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLwr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LwrContext lwr() throws RecognitionException {
		LwrContext _localctx = new LwrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lwr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(73);
				letClause();
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(76);
				whereClause();
				}
			}

			setState(79);
			returnClause();
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

	public static class LetClauseContext extends ParserRuleContext {
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_letClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__12);
			setState(82);
			varname();
			setState(83);
			match(T__13);
			setState(84);
			query(0);
			{
			setState(85);
			match(T__2);
			setState(86);
			varname();
			setState(87);
			match(T__13);
			setState(88);
			query(0);
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

	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__14);
			setState(91);
			cond(0);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__15);
			setState(94);
			query(0);
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

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ApdoubleslashContext extends ApContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ApdoubleslashContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitApdoubleslash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApslashContext extends ApContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ApslashContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitApslash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ap);
		int _la;
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ApslashContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(97);
				sentence();
				setState(98);
				match(T__1);
				setState(99);
				match(T__3);
				setState(100);
				rp(0);
				}
				break;
			case 2:
				_localctx = new ApdoubleslashContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(103);
				sentence();
				setState(104);
				match(T__1);
				setState(105);
				match(T__4);
				setState(106);
				rp(0);
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

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RpparenContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpparenContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpparen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpselfContext extends RpContext {
		public RpselfContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpself(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpparentContext extends RpContext {
		public RpparentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpparent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RptextContext extends RpContext {
		public RptextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRptext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpslashContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RpslashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpslash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpdoubleslashContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RpdoubleslashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpdoubleslash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RptagContext extends RpContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public RptagContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRptag(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpchildContext extends RpContext {
		public RpchildContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpchild(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpcancatContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RpcancatContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpcancat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpfilterContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public RpfilterContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpfilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpattrContext extends RpContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public RpattrContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpattr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringConstant:
				{
				_localctx = new RptagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(111);
				string();
				}
				break;
			case T__18:
				{
				_localctx = new RpchildContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(T__18);
				}
				break;
			case T__19:
				{
				_localctx = new RpselfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(T__19);
				}
				break;
			case T__20:
				{
				_localctx = new RpparentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(T__20);
				}
				break;
			case T__21:
				{
				_localctx = new RptextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(T__21);
				}
				break;
			case T__22:
				{
				_localctx = new RpattrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(T__22);
				setState(117);
				string();
				}
				break;
			case T__0:
				{
				_localctx = new RpparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(T__0);
				setState(119);
				rp(0);
				setState(120);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new RpslashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(124);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(125);
						match(T__3);
						setState(126);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RpdoubleslashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(127);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(128);
						match(T__4);
						setState(129);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RpcancatContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(130);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(131);
						match(T__2);
						setState(132);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RpfilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(133);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(134);
						match(T__23);
						setState(135);
						f(0);
						setState(136);
						match(T__24);
						}
						break;
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FltorContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public FltorContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltnotContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FltnotContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltnot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrpeqContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public FltrpeqContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrpeq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrpvaleqContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public FltrpvaleqContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrpvaleq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrpContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FltrpContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltparenContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FltparenContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltparen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltandContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public FltandContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new FltrpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(144);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new FltrpvaleqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				rp(0);
				setState(146);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(147);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new FltrpeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				rp(0);
				setState(150);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new FltparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(T__0);
				setState(154);
				f(0);
				setState(155);
				match(T__1);
				}
				break;
			case 5:
				{
				_localctx = new FltnotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(T__31);
				setState(158);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(167);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new FltandContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(161);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(162);
						match(T__29);
						setState(163);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new FltorContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						match(T__30);
						setState(166);
						f(3);
						}
						break;
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class VarnameContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(XQueryParser.Var, 0); }
		public VarnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitVarname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(Var);
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

	public static class SentenceContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(XQueryParser.StringLiteral, 0); }
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(StringLiteral);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode StringConstant() { return getToken(XQueryParser.StringConstant, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(StringConstant);
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

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondeqContext extends CondContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public CondeqContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondeq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondnotContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondnotContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondnot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondvaleqContext extends CondContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public CondvaleqContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondvaleq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondemptyContext extends CondContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public CondemptyContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondempty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondexistContext extends CondContext {
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondexistContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondexist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondandContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondandContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondorContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondorContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondparenContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondparenContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondparen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new CondvaleqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(179);
				query(0);
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(181);
				query(0);
				}
				break;
			case 2:
				{
				_localctx = new CondeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				query(0);
				setState(184);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				query(0);
				}
				break;
			case 3:
				{
				_localctx = new CondemptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(T__32);
				setState(188);
				match(T__0);
				setState(189);
				query(0);
				setState(190);
				match(T__1);
				}
				break;
			case 4:
				{
				_localctx = new CondexistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(T__33);
				setState(193);
				varname();
				setState(194);
				match(T__11);
				setState(195);
				query(0);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(196);
					match(T__2);
					setState(197);
					varname();
					setState(198);
					match(T__11);
					setState(199);
					query(0);
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(T__34);
				setState(207);
				cond(5);
				}
				break;
			case 5:
				{
				_localctx = new CondparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(T__0);
				setState(210);
				cond(0);
				setState(211);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new CondnotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(T__31);
				setState(214);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new CondandContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(217);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(218);
						match(T__29);
						setState(219);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new CondorContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(220);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(221);
						match(T__30);
						setState(222);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		case 0:
			return query_sempred((QueryContext)_localctx, predIndex);
		case 7:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 8:
			return f_sempred((FContext)_localctx, predIndex);
		case 12:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean query_sempred(QueryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u00e7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\64\n\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2?\n\2\f\2\16\2B\13\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3J\n\3\3\4\5\4M\n\4\3\4\5\4P\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\bo\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t}\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\t\u008d\n\t\f\t\16\t\u0090\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a2\n\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\7\n\u00aa\n\n\f\n\16\n\u00ad\13\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00cc\n\16\f\16\16\16\u00cf\13"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00da\n\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u00e2\n\16\f\16\16\16\u00e5\13\16\3\16"+
		"\2\6\2\20\22\32\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\5\3\2\23\24\3\2"+
		"\34\35\3\2\36\37\u00fe\2\63\3\2\2\2\4C\3\2\2\2\6L\3\2\2\2\bS\3\2\2\2\n"+
		"\\\3\2\2\2\f_\3\2\2\2\16n\3\2\2\2\20|\3\2\2\2\22\u00a1\3\2\2\2\24\u00ae"+
		"\3\2\2\2\26\u00b0\3\2\2\2\30\u00b2\3\2\2\2\32\u00d9\3\2\2\2\34\35\b\2"+
		"\1\2\35\64\5\24\13\2\36\64\5\26\f\2\37\64\5\16\b\2 !\7\3\2\2!\"\5\2\2"+
		"\2\"#\7\4\2\2#\64\3\2\2\2$%\7\b\2\2%&\5\30\r\2&\'\7\t\2\2\'(\7\n\2\2("+
		")\5\2\2\2)*\7\13\2\2*+\7\f\2\2+,\5\30\r\2,-\7\t\2\2-\64\3\2\2\2./\7\r"+
		"\2\2/\64\5\4\3\2\60\61\5\b\5\2\61\62\5\2\2\3\62\64\3\2\2\2\63\34\3\2\2"+
		"\2\63\36\3\2\2\2\63\37\3\2\2\2\63 \3\2\2\2\63$\3\2\2\2\63.\3\2\2\2\63"+
		"\60\3\2\2\2\64@\3\2\2\2\65\66\f\b\2\2\66\67\7\5\2\2\67?\5\2\2\t89\f\7"+
		"\2\29:\7\6\2\2:?\5\20\t\2;<\f\6\2\2<=\7\7\2\2=?\5\20\t\2>\65\3\2\2\2>"+
		"8\3\2\2\2>;\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\3\3\2\2\2B@\3\2\2\2"+
		"CD\5\24\13\2DE\7\16\2\2EI\5\2\2\2FJ\5\6\4\2GH\7\5\2\2HJ\5\4\3\2IF\3\2"+
		"\2\2IG\3\2\2\2J\5\3\2\2\2KM\5\b\5\2LK\3\2\2\2LM\3\2\2\2MO\3\2\2\2NP\5"+
		"\n\6\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\5\f\7\2R\7\3\2\2\2ST\7\17\2\2T"+
		"U\5\24\13\2UV\7\20\2\2VW\5\2\2\2WX\7\5\2\2XY\5\24\13\2YZ\7\20\2\2Z[\5"+
		"\2\2\2[\t\3\2\2\2\\]\7\21\2\2]^\5\32\16\2^\13\3\2\2\2_`\7\22\2\2`a\5\2"+
		"\2\2a\r\3\2\2\2bc\t\2\2\2cd\5\26\f\2de\7\4\2\2ef\7\6\2\2fg\5\20\t\2go"+
		"\3\2\2\2hi\t\2\2\2ij\5\26\f\2jk\7\4\2\2kl\7\7\2\2lm\5\20\t\2mo\3\2\2\2"+
		"nb\3\2\2\2nh\3\2\2\2o\17\3\2\2\2pq\b\t\1\2q}\5\30\r\2r}\7\25\2\2s}\7\26"+
		"\2\2t}\7\27\2\2u}\7\30\2\2vw\7\31\2\2w}\5\30\r\2xy\7\3\2\2yz\5\20\t\2"+
		"z{\7\4\2\2{}\3\2\2\2|p\3\2\2\2|r\3\2\2\2|s\3\2\2\2|t\3\2\2\2|u\3\2\2\2"+
		"|v\3\2\2\2|x\3\2\2\2}\u008e\3\2\2\2~\177\f\6\2\2\177\u0080\7\6\2\2\u0080"+
		"\u008d\5\20\t\7\u0081\u0082\f\5\2\2\u0082\u0083\7\7\2\2\u0083\u008d\5"+
		"\20\t\6\u0084\u0085\f\3\2\2\u0085\u0086\7\5\2\2\u0086\u008d\5\20\t\4\u0087"+
		"\u0088\f\4\2\2\u0088\u0089\7\32\2\2\u0089\u008a\5\22\n\2\u008a\u008b\7"+
		"\33\2\2\u008b\u008d\3\2\2\2\u008c~\3\2\2\2\u008c\u0081\3\2\2\2\u008c\u0084"+
		"\3\2\2\2\u008c\u0087\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\21\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\b\n\1"+
		"\2\u0092\u00a2\5\20\t\2\u0093\u0094\5\20\t\2\u0094\u0095\t\3\2\2\u0095"+
		"\u0096\5\20\t\2\u0096\u00a2\3\2\2\2\u0097\u0098\5\20\t\2\u0098\u0099\t"+
		"\4\2\2\u0099\u009a\5\20\t\2\u009a\u00a2\3\2\2\2\u009b\u009c\7\3\2\2\u009c"+
		"\u009d\5\22\n\2\u009d\u009e\7\4\2\2\u009e\u00a2\3\2\2\2\u009f\u00a0\7"+
		"\"\2\2\u00a0\u00a2\5\22\n\3\u00a1\u0091\3\2\2\2\u00a1\u0093\3\2\2\2\u00a1"+
		"\u0097\3\2\2\2\u00a1\u009b\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00ab\3\2"+
		"\2\2\u00a3\u00a4\f\5\2\2\u00a4\u00a5\7 \2\2\u00a5\u00aa\5\22\n\6\u00a6"+
		"\u00a7\f\4\2\2\u00a7\u00a8\7!\2\2\u00a8\u00aa\5\22\n\5\u00a9\u00a3\3\2"+
		"\2\2\u00a9\u00a6\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\23\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7(\2\2"+
		"\u00af\25\3\2\2\2\u00b0\u00b1\7&\2\2\u00b1\27\3\2\2\2\u00b2\u00b3\7\'"+
		"\2\2\u00b3\31\3\2\2\2\u00b4\u00b5\b\16\1\2\u00b5\u00b6\5\2\2\2\u00b6\u00b7"+
		"\t\3\2\2\u00b7\u00b8\5\2\2\2\u00b8\u00da\3\2\2\2\u00b9\u00ba\5\2\2\2\u00ba"+
		"\u00bb\t\4\2\2\u00bb\u00bc\5\2\2\2\u00bc\u00da\3\2\2\2\u00bd\u00be\7#"+
		"\2\2\u00be\u00bf\7\3\2\2\u00bf\u00c0\5\2\2\2\u00c0\u00c1\7\4\2\2\u00c1"+
		"\u00da\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3\u00c4\5\24\13\2\u00c4\u00c5\7"+
		"\16\2\2\u00c5\u00cd\5\2\2\2\u00c6\u00c7\7\5\2\2\u00c7\u00c8\5\24\13\2"+
		"\u00c8\u00c9\7\16\2\2\u00c9\u00ca\5\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c6"+
		"\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7%\2\2\u00d1\u00d2\5\32"+
		"\16\7\u00d2\u00da\3\2\2\2\u00d3\u00d4\7\3\2\2\u00d4\u00d5\5\32\16\2\u00d5"+
		"\u00d6\7\4\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d8\7\"\2\2\u00d8\u00da\5\32"+
		"\16\3\u00d9\u00b4\3\2\2\2\u00d9\u00b9\3\2\2\2\u00d9\u00bd\3\2\2\2\u00d9"+
		"\u00c2\3\2\2\2\u00d9\u00d3\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00e3\3\2"+
		"\2\2\u00db\u00dc\f\5\2\2\u00dc\u00dd\7 \2\2\u00dd\u00e2\5\32\16\6\u00de"+
		"\u00df\f\4\2\2\u00df\u00e0\7!\2\2\u00e0\u00e2\5\32\16\5\u00e1\u00db\3"+
		"\2\2\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\33\3\2\2\2\u00e5\u00e3\3\2\2\2\23\63>@ILOn|\u008c"+
		"\u008e\u00a1\u00a9\u00ab\u00cd\u00d9\u00e1\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}