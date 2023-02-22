// Generated from java-escape by ANTLR 4.11.1
package gen.babycobol;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BabyCobolParser}.
 */
public interface BabyCobolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BabyCobolParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BabyCobolParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(BabyCobolParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(BabyCobolParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#accept}.
	 * @param ctx the parse tree
	 */
	void enterAccept(BabyCobolParser.AcceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#accept}.
	 * @param ctx the parse tree
	 */
	void exitAccept(BabyCobolParser.AcceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(BabyCobolParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(BabyCobolParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#subtract}.
	 * @param ctx the parse tree
	 */
	void enterSubtract(BabyCobolParser.SubtractContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#subtract}.
	 * @param ctx the parse tree
	 */
	void exitSubtract(BabyCobolParser.SubtractContext ctx);
}