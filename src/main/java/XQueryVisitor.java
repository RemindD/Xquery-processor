// Generated from /Users/richard/Documents/graduate study/2nd semester/CS232B/project/xquery/src/main/resources/XQuery.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code xqap}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqap(XQueryParser.XqapContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqtag}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqtag(XQueryParser.XqtagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqconcat}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqconcat(XQueryParser.XqconcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqlet}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqlet(XQueryParser.XqletContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqslash}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqslash(XQueryParser.XqslashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqparen}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqparen(XQueryParser.XqparenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqflwr}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqflwr(XQueryParser.XqflwrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqstring}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqstring(XQueryParser.XqstringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqdoubleslash}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqdoubleslash(XQueryParser.XqdoubleslashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqvar}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqvar(XQueryParser.XqvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#flwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlwr(XQueryParser.FlwrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#lwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLwr(XQueryParser.LwrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apslash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApslash(XQueryParser.ApslashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apdoubleslash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApdoubleslash(XQueryParser.ApdoubleslashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpparen}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpparen(XQueryParser.RpparenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpself}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpself(XQueryParser.RpselfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpparent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpparent(XQueryParser.RpparentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rptext}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRptext(XQueryParser.RptextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpslash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpslash(XQueryParser.RpslashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpdoubleslash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpdoubleslash(XQueryParser.RpdoubleslashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rptag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRptag(XQueryParser.RptagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpchild}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpchild(XQueryParser.RpchildContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpcancat}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpcancat(XQueryParser.RpcancatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpfilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpfilter(XQueryParser.RpfilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpattr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpattr(XQueryParser.RpattrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fltor}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltor(XQueryParser.FltorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fltnot}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltnot(XQueryParser.FltnotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fltrpeq}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrpeq(XQueryParser.FltrpeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fltrpvaleq}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrpvaleq(XQueryParser.FltrpvaleqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fltrp}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrp(XQueryParser.FltrpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fltparen}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltparen(XQueryParser.FltparenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fltand}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltand(XQueryParser.FltandContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#varname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarname(XQueryParser.VarnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(XQueryParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(XQueryParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condeq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondeq(XQueryParser.CondeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condnot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondnot(XQueryParser.CondnotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condvaleq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondvaleq(XQueryParser.CondvaleqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condempty}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondempty(XQueryParser.CondemptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condexist}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondexist(XQueryParser.CondexistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condand}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondand(XQueryParser.CondandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condor}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondor(XQueryParser.CondorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condparen}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondparen(XQueryParser.CondparenContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#somecond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomecond(XQueryParser.SomecondContext ctx);
}