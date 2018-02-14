// Generated from /home/alessio/Sviluppo/Java/tecnling_vgg/retoricaweb/src/main/java/euporia/tecnling/retoricaweb/dsl/dsltest/DslTest.g4 by ANTLR 4.7
package euporia.tecnling.retoricaweb.dsl.dsltest;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DslTestParser}.
 */
public interface DslTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DslTestParser#taggedSentence}.
	 * @param ctx the parse tree
	 */
	void enterTaggedSentence(DslTestParser.TaggedSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#taggedSentence}.
	 * @param ctx the parse tree
	 */
	void exitTaggedSentence(DslTestParser.TaggedSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(DslTestParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(DslTestParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#mf}.
	 * @param ctx the parse tree
	 */
	void enterMf(DslTestParser.MfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#mf}.
	 * @param ctx the parse tree
	 */
	void exitMf(DslTestParser.MfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#sml}.
	 * @param ctx the parse tree
	 */
	void enterSml(DslTestParser.SmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#sml}.
	 * @param ctx the parse tree
	 */
	void exitSml(DslTestParser.SmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#firstTerm}.
	 * @param ctx the parse tree
	 */
	void enterFirstTerm(DslTestParser.FirstTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#firstTerm}.
	 * @param ctx the parse tree
	 */
	void exitFirstTerm(DslTestParser.FirstTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#secondTerm}.
	 * @param ctx the parse tree
	 */
	void enterSecondTerm(DslTestParser.SecondTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#secondTerm}.
	 * @param ctx the parse tree
	 */
	void exitSecondTerm(DslTestParser.SecondTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#anf}.
	 * @param ctx the parse tree
	 */
	void enterAnf(DslTestParser.AnfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#anf}.
	 * @param ctx the parse tree
	 */
	void exitAnf(DslTestParser.AnfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#endmf}.
	 * @param ctx the parse tree
	 */
	void enterEndmf(DslTestParser.EndmfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#endmf}.
	 * @param ctx the parse tree
	 */
	void exitEndmf(DslTestParser.EndmfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#endsml}.
	 * @param ctx the parse tree
	 */
	void enterEndsml(DslTestParser.EndsmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#endsml}.
	 * @param ctx the parse tree
	 */
	void exitEndsml(DslTestParser.EndsmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslTestParser#endanf}.
	 * @param ctx the parse tree
	 */
	void enterEndanf(DslTestParser.EndanfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslTestParser#endanf}.
	 * @param ctx the parse tree
	 */
	void exitEndanf(DslTestParser.EndanfContext ctx);
}