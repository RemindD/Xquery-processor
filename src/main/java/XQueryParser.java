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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, StringLiteral=37, StringConstant=38, 
		Var=39, WS=40;
	public static final int
		RULE_query = 0, RULE_flwr = 1, RULE_lwr = 2, RULE_letClause = 3, RULE_whereClause = 4, 
		RULE_joinClause = 5, RULE_attrPairs = 6, RULE_returnClause = 7, RULE_ap = 8, 
		RULE_rp = 9, RULE_f = 10, RULE_varname = 11, RULE_sentence = 12, RULE_string = 13, 
		RULE_cond = 14, RULE_somecond = 15;
	public static final String[] ruleNames = {
		"query", "flwr", "lwr", "letClause", "whereClause", "joinClause", "attrPairs", 
		"returnClause", "ap", "rp", "f", "varname", "sentence", "string", "cond", 
		"somecond"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'/'", "'//'", "','", "'<'", "'>'", "'{'", "'}'", 
		"'</'", "'for'", "'in'", "'let'", "':='", "'where'", "'join'", "'['", 
		"']'", "'return'", "'doc('", "'document('", "'*'", "'.'", "'..'", "'text()'", 
		"'@'", "'='", "'eq'", "'=='", "'is'", "'and'", "'or'", "'not'", "'empty'", 
		"'some'", "'satisfies'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "StringLiteral", "StringConstant", "Var", "WS"
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
	public static class XqJoinContext extends QueryContext {
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public XqJoinContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqJoin(this);
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
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				{
				_localctx = new XqvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(33);
				varname();
				}
				break;
			case StringLiteral:
				{
				_localctx = new XqstringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				sentence();
				}
				break;
			case T__19:
			case T__20:
				{
				_localctx = new XqapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				ap();
				}
				break;
			case T__0:
				{
				_localctx = new XqparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(T__0);
				setState(37);
				query(0);
				setState(38);
				match(T__1);
				}
				break;
			case T__5:
				{
				_localctx = new XqtagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(T__5);
				setState(41);
				string();
				setState(42);
				match(T__6);
				setState(43);
				match(T__7);
				setState(44);
				query(0);
				setState(45);
				match(T__8);
				setState(46);
				match(T__9);
				setState(47);
				string();
				setState(48);
				match(T__6);
				}
				break;
			case T__10:
				{
				_localctx = new XqflwrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				match(T__10);
				setState(51);
				flwr();
				}
				break;
			case T__12:
				{
				_localctx = new XqletContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				letClause();
				setState(53);
				query(2);
				}
				break;
			case T__15:
				{
				_localctx = new XqJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				joinClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(67);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new XqconcatContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(58);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(59);
						match(T__4);
						setState(60);
						query(6);
						}
						break;
					case 2:
						{
						_localctx = new XqslashContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(61);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(62);
						match(T__2);
						setState(63);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XqdoubleslashContext(new QueryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_query);
						setState(64);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(65);
						match(T__3);
						setState(66);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(71);
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
			setState(72);
			varname();
			setState(73);
			match(T__11);
			setState(74);
			query(0);
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__14:
			case T__18:
				{
				setState(75);
				lwr();
				}
				break;
			case T__4:
				{
				{
				setState(76);
				match(T__4);
				setState(77);
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
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(80);
				letClause();
				}
			}

			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(83);
				whereClause();
				}
			}

			setState(86);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__12);
			setState(89);
			varname();
			setState(90);
			match(T__13);
			setState(91);
			query(0);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(92);
				match(T__4);
				setState(93);
				varname();
				setState(94);
				match(T__13);
				setState(95);
				query(0);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			setState(102);
			match(T__14);
			setState(103);
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

	public static class JoinClauseContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<AttrPairsContext> attrPairs() {
			return getRuleContexts(AttrPairsContext.class);
		}
		public AttrPairsContext attrPairs(int i) {
			return getRuleContext(AttrPairsContext.class,i);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitJoinClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_joinClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__15);
			setState(106);
			match(T__0);
			setState(107);
			query(0);
			setState(108);
			match(T__4);
			setState(109);
			query(0);
			setState(110);
			match(T__4);
			setState(111);
			attrPairs();
			setState(112);
			match(T__4);
			setState(113);
			attrPairs();
			setState(114);
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

	public static class AttrPairsContext extends ParserRuleContext {
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public AttrPairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrPairs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAttrPairs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrPairsContext attrPairs() throws RecognitionException {
		AttrPairsContext _localctx = new AttrPairsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attrPairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__16);
			setState(117);
			string();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(118);
				match(T__4);
				setState(119);
				string();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
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
		enterRule(_localctx, 14, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__18);
			setState(128);
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
		enterRule(_localctx, 16, RULE_ap);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ApslashContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(131);
				sentence();
				setState(132);
				match(T__1);
				setState(133);
				match(T__2);
				setState(134);
				rp(0);
				}
				break;
			case 2:
				_localctx = new ApdoubleslashContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(137);
				sentence();
				setState(138);
				match(T__1);
				setState(139);
				match(T__3);
				setState(140);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringConstant:
				{
				_localctx = new RptagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(145);
				string();
				}
				break;
			case T__21:
				{
				_localctx = new RpchildContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(T__21);
				}
				break;
			case T__22:
				{
				_localctx = new RpselfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(T__22);
				}
				break;
			case T__23:
				{
				_localctx = new RpparentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(T__23);
				}
				break;
			case T__24:
				{
				_localctx = new RptextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(T__24);
				}
				break;
			case T__25:
				{
				_localctx = new RpattrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(T__25);
				setState(151);
				string();
				}
				break;
			case T__0:
				{
				_localctx = new RpparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(T__0);
				setState(153);
				rp(0);
				setState(154);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new RpslashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(158);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(159);
						match(T__2);
						setState(160);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RpdoubleslashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(161);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(162);
						match(T__3);
						setState(163);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RpcancatContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(164);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(165);
						match(T__4);
						setState(166);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RpfilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(167);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(168);
						match(T__16);
						setState(169);
						f(0);
						setState(170);
						match(T__17);
						}
						break;
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new FltrpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(178);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new FltrpvaleqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				rp(0);
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(181);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new FltrpeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				rp(0);
				setState(184);
				_la = _input.LA(1);
				if ( !(_la==T__28 || _la==T__29) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new FltparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(T__0);
				setState(188);
				f(0);
				setState(189);
				match(T__1);
				}
				break;
			case 5:
				{
				_localctx = new FltnotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(T__32);
				setState(192);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(201);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new FltandContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(195);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(196);
						match(T__30);
						setState(197);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new FltorContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(198);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(199);
						match(T__31);
						setState(200);
						f(3);
						}
						break;
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 22, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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
		enterRule(_localctx, 24, RULE_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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
		enterRule(_localctx, 26, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
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
		public SomecondContext somecond() {
			return getRuleContext(SomecondContext.class,0);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new CondvaleqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(213);
				query(0);
				setState(214);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				query(0);
				}
				break;
			case 2:
				{
				_localctx = new CondeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				query(0);
				setState(218);
				_la = _input.LA(1);
				if ( !(_la==T__28 || _la==T__29) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(219);
				query(0);
				}
				break;
			case 3:
				{
				_localctx = new CondemptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(T__33);
				setState(222);
				match(T__0);
				setState(223);
				query(0);
				setState(224);
				match(T__1);
				}
				break;
			case 4:
				{
				_localctx = new CondexistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				somecond();
				}
				break;
			case 5:
				{
				_localctx = new CondparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(T__0);
				setState(228);
				cond(0);
				setState(229);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new CondnotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(T__32);
				setState(232);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(241);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new CondandContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(235);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(236);
						match(T__30);
						setState(237);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new CondorContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(238);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(239);
						match(T__31);
						setState(240);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class SomecondContext extends ParserRuleContext {
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SomecondContext somecond() {
			return getRuleContext(SomecondContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public SomecondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_somecond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitSomecond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SomecondContext somecond() throws RecognitionException {
		SomecondContext _localctx = new SomecondContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_somecond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__34);
			setState(247);
			varname();
			setState(248);
			match(T__11);
			setState(249);
			query(0);
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				{
				setState(250);
				somecond();
				}
				break;
			case T__35:
				{
				{
				setState(251);
				match(T__35);
				setState(252);
				cond(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return query_sempred((QueryContext)_localctx, predIndex);
		case 9:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 10:
			return f_sempred((FContext)_localctx, predIndex);
		case 14:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean query_sempred(QueryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u0102\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2;\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2F\n\2"+
		"\f\2\16\2I\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3Q\n\3\3\4\5\4T\n\4\3\4\5\4"+
		"W\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5d\n\5\f\5\16\5g\13"+
		"\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\7\b{\n\b\f\b\16\b~\13\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0091\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009f\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00af\n\13\f\13\16"+
		"\13\u00b2\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00c4\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00cc\n\f\f\f\16"+
		"\f\u00cf\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00ec\n\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00f4\n\20\f"+
		"\20\16\20\u00f7\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0100\n"+
		"\21\3\21\2\6\2\24\26\36\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\5"+
		"\3\2\26\27\3\2\35\36\3\2\37 \u0119\2:\3\2\2\2\4J\3\2\2\2\6S\3\2\2\2\b"+
		"Z\3\2\2\2\nh\3\2\2\2\fk\3\2\2\2\16v\3\2\2\2\20\u0081\3\2\2\2\22\u0090"+
		"\3\2\2\2\24\u009e\3\2\2\2\26\u00c3\3\2\2\2\30\u00d0\3\2\2\2\32\u00d2\3"+
		"\2\2\2\34\u00d4\3\2\2\2\36\u00eb\3\2\2\2 \u00f8\3\2\2\2\"#\b\2\1\2#;\5"+
		"\30\r\2$;\5\32\16\2%;\5\22\n\2&\'\7\3\2\2\'(\5\2\2\2()\7\4\2\2);\3\2\2"+
		"\2*+\7\b\2\2+,\5\34\17\2,-\7\t\2\2-.\7\n\2\2./\5\2\2\2/\60\7\13\2\2\60"+
		"\61\7\f\2\2\61\62\5\34\17\2\62\63\7\t\2\2\63;\3\2\2\2\64\65\7\r\2\2\65"+
		";\5\4\3\2\66\67\5\b\5\2\678\5\2\2\48;\3\2\2\29;\5\f\7\2:\"\3\2\2\2:$\3"+
		"\2\2\2:%\3\2\2\2:&\3\2\2\2:*\3\2\2\2:\64\3\2\2\2:\66\3\2\2\2:9\3\2\2\2"+
		";G\3\2\2\2<=\f\7\2\2=>\7\7\2\2>F\5\2\2\b?@\f\t\2\2@A\7\5\2\2AF\5\24\13"+
		"\2BC\f\b\2\2CD\7\6\2\2DF\5\24\13\2E<\3\2\2\2E?\3\2\2\2EB\3\2\2\2FI\3\2"+
		"\2\2GE\3\2\2\2GH\3\2\2\2H\3\3\2\2\2IG\3\2\2\2JK\5\30\r\2KL\7\16\2\2LP"+
		"\5\2\2\2MQ\5\6\4\2NO\7\7\2\2OQ\5\4\3\2PM\3\2\2\2PN\3\2\2\2Q\5\3\2\2\2"+
		"RT\5\b\5\2SR\3\2\2\2ST\3\2\2\2TV\3\2\2\2UW\5\n\6\2VU\3\2\2\2VW\3\2\2\2"+
		"WX\3\2\2\2XY\5\20\t\2Y\7\3\2\2\2Z[\7\17\2\2[\\\5\30\r\2\\]\7\20\2\2]e"+
		"\5\2\2\2^_\7\7\2\2_`\5\30\r\2`a\7\20\2\2ab\5\2\2\2bd\3\2\2\2c^\3\2\2\2"+
		"dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\t\3\2\2\2ge\3\2\2\2hi\7\21\2\2ij\5\36"+
		"\20\2j\13\3\2\2\2kl\7\22\2\2lm\7\3\2\2mn\5\2\2\2no\7\7\2\2op\5\2\2\2p"+
		"q\7\7\2\2qr\5\16\b\2rs\7\7\2\2st\5\16\b\2tu\7\4\2\2u\r\3\2\2\2vw\7\23"+
		"\2\2w|\5\34\17\2xy\7\7\2\2y{\5\34\17\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|"+
		"}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7\24\2\2\u0080\17\3\2\2\2\u0081"+
		"\u0082\7\25\2\2\u0082\u0083\5\2\2\2\u0083\21\3\2\2\2\u0084\u0085\t\2\2"+
		"\2\u0085\u0086\5\32\16\2\u0086\u0087\7\4\2\2\u0087\u0088\7\5\2\2\u0088"+
		"\u0089\5\24\13\2\u0089\u0091\3\2\2\2\u008a\u008b\t\2\2\2\u008b\u008c\5"+
		"\32\16\2\u008c\u008d\7\4\2\2\u008d\u008e\7\6\2\2\u008e\u008f\5\24\13\2"+
		"\u008f\u0091\3\2\2\2\u0090\u0084\3\2\2\2\u0090\u008a\3\2\2\2\u0091\23"+
		"\3\2\2\2\u0092\u0093\b\13\1\2\u0093\u009f\5\34\17\2\u0094\u009f\7\30\2"+
		"\2\u0095\u009f\7\31\2\2\u0096\u009f\7\32\2\2\u0097\u009f\7\33\2\2\u0098"+
		"\u0099\7\34\2\2\u0099\u009f\5\34\17\2\u009a\u009b\7\3\2\2\u009b\u009c"+
		"\5\24\13\2\u009c\u009d\7\4\2\2\u009d\u009f\3\2\2\2\u009e\u0092\3\2\2\2"+
		"\u009e\u0094\3\2\2\2\u009e\u0095\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u0097"+
		"\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009a\3\2\2\2\u009f\u00b0\3\2\2\2\u00a0"+
		"\u00a1\f\6\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00af\5\24\13\7\u00a3\u00a4\f"+
		"\5\2\2\u00a4\u00a5\7\6\2\2\u00a5\u00af\5\24\13\6\u00a6\u00a7\f\3\2\2\u00a7"+
		"\u00a8\7\7\2\2\u00a8\u00af\5\24\13\4\u00a9\u00aa\f\4\2\2\u00aa\u00ab\7"+
		"\23\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\7\24\2\2\u00ad\u00af\3\2\2\2"+
		"\u00ae\u00a0\3\2\2\2\u00ae\u00a3\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00a9"+
		"\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\25\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\b\f\1\2\u00b4\u00c4\5\24\13"+
		"\2\u00b5\u00b6\5\24\13\2\u00b6\u00b7\t\3\2\2\u00b7\u00b8\5\24\13\2\u00b8"+
		"\u00c4\3\2\2\2\u00b9\u00ba\5\24\13\2\u00ba\u00bb\t\4\2\2\u00bb\u00bc\5"+
		"\24\13\2\u00bc\u00c4\3\2\2\2\u00bd\u00be\7\3\2\2\u00be\u00bf\5\26\f\2"+
		"\u00bf\u00c0\7\4\2\2\u00c0\u00c4\3\2\2\2\u00c1\u00c2\7#\2\2\u00c2\u00c4"+
		"\5\26\f\3\u00c3\u00b3\3\2\2\2\u00c3\u00b5\3\2\2\2\u00c3\u00b9\3\2\2\2"+
		"\u00c3\u00bd\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00cd\3\2\2\2\u00c5\u00c6"+
		"\f\5\2\2\u00c6\u00c7\7!\2\2\u00c7\u00cc\5\26\f\6\u00c8\u00c9\f\4\2\2\u00c9"+
		"\u00ca\7\"\2\2\u00ca\u00cc\5\26\f\5\u00cb\u00c5\3\2\2\2\u00cb\u00c8\3"+
		"\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\27\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7)\2\2\u00d1\31\3\2\2\2\u00d2"+
		"\u00d3\7\'\2\2\u00d3\33\3\2\2\2\u00d4\u00d5\7(\2\2\u00d5\35\3\2\2\2\u00d6"+
		"\u00d7\b\20\1\2\u00d7\u00d8\5\2\2\2\u00d8\u00d9\t\3\2\2\u00d9\u00da\5"+
		"\2\2\2\u00da\u00ec\3\2\2\2\u00db\u00dc\5\2\2\2\u00dc\u00dd\t\4\2\2\u00dd"+
		"\u00de\5\2\2\2\u00de\u00ec\3\2\2\2\u00df\u00e0\7$\2\2\u00e0\u00e1\7\3"+
		"\2\2\u00e1\u00e2\5\2\2\2\u00e2\u00e3\7\4\2\2\u00e3\u00ec\3\2\2\2\u00e4"+
		"\u00ec\5 \21\2\u00e5\u00e6\7\3\2\2\u00e6\u00e7\5\36\20\2\u00e7\u00e8\7"+
		"\4\2\2\u00e8\u00ec\3\2\2\2\u00e9\u00ea\7#\2\2\u00ea\u00ec\5\36\20\3\u00eb"+
		"\u00d6\3\2\2\2\u00eb\u00db\3\2\2\2\u00eb\u00df\3\2\2\2\u00eb\u00e4\3\2"+
		"\2\2\u00eb\u00e5\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00f5\3\2\2\2\u00ed"+
		"\u00ee\f\5\2\2\u00ee\u00ef\7!\2\2\u00ef\u00f4\5\36\20\6\u00f0\u00f1\f"+
		"\4\2\2\u00f1\u00f2\7\"\2\2\u00f2\u00f4\5\36\20\5\u00f3\u00ed\3\2\2\2\u00f3"+
		"\u00f0\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\37\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7%\2\2\u00f9\u00fa"+
		"\5\30\r\2\u00fa\u00fb\7\16\2\2\u00fb\u00ff\5\2\2\2\u00fc\u0100\5 \21\2"+
		"\u00fd\u00fe\7&\2\2\u00fe\u0100\5\36\20\2\u00ff\u00fc\3\2\2\2\u00ff\u00fd"+
		"\3\2\2\2\u0100!\3\2\2\2\25:EGPSVe|\u0090\u009e\u00ae\u00b0\u00c3\u00cb"+
		"\u00cd\u00eb\u00f3\u00f5\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}