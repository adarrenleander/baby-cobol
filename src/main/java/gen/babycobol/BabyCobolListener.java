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
	 * Enter a parse tree produced by {@link BabyCobolParser#identification_division}.
	 * @param ctx the parse tree
	 */
	void enterIdentification_division(BabyCobolParser.Identification_divisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#identification_division}.
	 * @param ctx the parse tree
	 */
	void exitIdentification_division(BabyCobolParser.Identification_divisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#data_divison}.
	 * @param ctx the parse tree
	 */
	void enterData_divison(BabyCobolParser.Data_divisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#data_divison}.
	 * @param ctx the parse tree
	 */
	void exitData_divison(BabyCobolParser.Data_divisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(BabyCobolParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(BabyCobolParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#picture}.
	 * @param ctx the parse tree
	 */
	void enterPicture(BabyCobolParser.PictureContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#picture}.
	 * @param ctx the parse tree
	 */
	void exitPicture(BabyCobolParser.PictureContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#like}.
	 * @param ctx the parse tree
	 */
	void enterLike(BabyCobolParser.LikeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#like}.
	 * @param ctx the parse tree
	 */
	void exitLike(BabyCobolParser.LikeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#occurs}.
	 * @param ctx the parse tree
	 */
	void enterOccurs(BabyCobolParser.OccursContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#occurs}.
	 * @param ctx the parse tree
	 */
	void exitOccurs(BabyCobolParser.OccursContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#procedure_division}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_division(BabyCobolParser.Procedure_divisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#procedure_division}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_division(BabyCobolParser.Procedure_divisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#using}.
	 * @param ctx the parse tree
	 */
	void enterUsing(BabyCobolParser.UsingContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#using}.
	 * @param ctx the parse tree
	 */
	void exitUsing(BabyCobolParser.UsingContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#using_expression}.
	 * @param ctx the parse tree
	 */
	void enterUsing_expression(BabyCobolParser.Using_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#using_expression}.
	 * @param ctx the parse tree
	 */
	void exitUsing_expression(BabyCobolParser.Using_expressionContext ctx);
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
	 * Enter a parse tree produced by {@link BabyCobolParser#divide}.
	 * @param ctx the parse tree
	 */
	void enterDivide(BabyCobolParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#divide}.
	 * @param ctx the parse tree
	 */
	void exitDivide(BabyCobolParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(BabyCobolParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(BabyCobolParser.MultiplyContext ctx);
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
	 * Enter a parse tree produced by {@link BabyCobolParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(BabyCobolParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(BabyCobolParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#evaluate}.
	 * @param ctx the parse tree
	 */
	void enterEvaluate(BabyCobolParser.EvaluateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#evaluate}.
	 * @param ctx the parse tree
	 */
	void exitEvaluate(BabyCobolParser.EvaluateContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#next_sentence}.
	 * @param ctx the parse tree
	 */
	void enterNext_sentence(BabyCobolParser.Next_sentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#next_sentence}.
	 * @param ctx the parse tree
	 */
	void exitNext_sentence(BabyCobolParser.Next_sentenceContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(BabyCobolParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(BabyCobolParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#remainder}.
	 * @param ctx the parse tree
	 */
	void enterRemainder(BabyCobolParser.RemainderContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#remainder}.
	 * @param ctx the parse tree
	 */
	void exitRemainder(BabyCobolParser.RemainderContext ctx);
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
	 * Enter a parse tree produced by the {@code loop_varying_expression}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void enterLoop_varying_expression(BabyCobolParser.Loop_varying_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop_varying_expression}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void exitLoop_varying_expression(BabyCobolParser.Loop_varying_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loop_while_expression}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void enterLoop_while_expression(BabyCobolParser.Loop_while_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop_while_expression}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void exitLoop_while_expression(BabyCobolParser.Loop_while_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loop_until_expression}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void enterLoop_until_expression(BabyCobolParser.Loop_until_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop_until_expression}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void exitLoop_until_expression(BabyCobolParser.Loop_until_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loop_statement_expession}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement_expession(BabyCobolParser.Loop_statement_expessionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop_statement_expession}
	 * labeled alternative in {@link BabyCobolParser#loop_expression}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement_expession(BabyCobolParser.Loop_statement_expessionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#any_expression}.
	 * @param ctx the parse tree
	 */
	void enterAny_expression(BabyCobolParser.Any_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#any_expression}.
	 * @param ctx the parse tree
	 */
	void exitAny_expression(BabyCobolParser.Any_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expression(BabyCobolParser.Arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expression(BabyCobolParser.Arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void enterString_expression(BabyCobolParser.String_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void exitString_expression(BabyCobolParser.String_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expression(BabyCobolParser.Boolean_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expression(BabyCobolParser.Boolean_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#when_block}.
	 * @param ctx the parse tree
	 */
	void enterWhen_block(BabyCobolParser.When_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#when_block}.
	 * @param ctx the parse tree
	 */
	void exitWhen_block(BabyCobolParser.When_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#atomic}.
	 * @param ctx the parse tree
	 */
	void enterAtomic(BabyCobolParser.AtomicContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#atomic}.
	 * @param ctx the parse tree
	 */
	void exitAtomic(BabyCobolParser.AtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyCobolParser#identifiers}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiers(BabyCobolParser.IdentifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyCobolParser#identifiers}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiers(BabyCobolParser.IdentifiersContext ctx);
}