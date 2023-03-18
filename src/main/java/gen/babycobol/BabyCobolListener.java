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
	 * Enter a parse tree produced by {@link BabyCobolParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(BabyCobolParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(BabyCobolParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#procname}.
	 * @param ctx the parse tree
	 */
	void enterProcname(BabyCobolParser.ProcnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#procname}.
	 * @param ctx the parse tree
	 */
	void exitProcname(BabyCobolParser.ProcnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BabyCobolParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BabyCobolParser.StatementContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#giving}.
	 * @param ctx the parse tree
	 */
	void enterGiving(BabyCobolParser.GivingContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#giving}.
	 * @param ctx the parse tree
	 */
	void exitGiving(BabyCobolParser.GivingContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#display}.
	 * @param ctx the parse tree
	 */
	void enterDisplay(BabyCobolParser.DisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#display}.
	 * @param ctx the parse tree
	 */
	void exitDisplay(BabyCobolParser.DisplayContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#withnoadvancing}.
	 * @param ctx the parse tree
	 */
	void enterWithnoadvancing(BabyCobolParser.WithnoadvancingContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#withnoadvancing}.
	 * @param ctx the parse tree
	 */
	void exitWithnoadvancing(BabyCobolParser.WithnoadvancingContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#stop}.
	 * @param ctx the parse tree
	 */
	void enterStop(BabyCobolParser.StopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#stop}.
	 * @param ctx the parse tree
	 */
	void exitStop(BabyCobolParser.StopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#perform}.
	 * @param ctx the parse tree
	 */
	void enterPerform(BabyCobolParser.PerformContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#perform}.
	 * @param ctx the parse tree
	 */
	void exitPerform(BabyCobolParser.PerformContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMove(BabyCobolParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMove(BabyCobolParser.MoveContext ctx);
}