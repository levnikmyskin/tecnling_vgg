// Generated from /home/alessio/Sviluppo/Java/tecnling_vgg/retoricaweb/src/main/java/euporia/tecnling/retoricaweb/dsl/dsltest/DslTest.g4 by ANTLR 4.7
package euporia.tecnling.retoricaweb.dsl.dsltest;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DslTestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DslTestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DslTestParser#taggedSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaggedSentence(DslTestParser.TaggedSentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(DslTestParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#mf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMf(DslTestParser.MfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#sml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSml(DslTestParser.SmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#firstTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstTerm(DslTestParser.FirstTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#secondTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondTerm(DslTestParser.SecondTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#anf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnf(DslTestParser.AnfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#endmf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndmf(DslTestParser.EndmfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#endsml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndsml(DslTestParser.EndsmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslTestParser#endanf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndanf(DslTestParser.EndanfContext ctx);
}