// Generated from java-escape by ANTLR 4.11.1
package gen.babycobol;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BabyCobolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BabyCobolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BabyCobolParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(BabyCobolParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#procname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcname(BabyCobolParser.ProcnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BabyCobolParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#accept}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccept(BabyCobolParser.AcceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(BabyCobolParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#subtract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtract(BabyCobolParser.SubtractContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#divide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(BabyCobolParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#multiply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(BabyCobolParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#perform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerform(BabyCobolParser.PerformContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#display}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay(BabyCobolParser.DisplayContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#stop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStop(BabyCobolParser.StopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(BabyCobolParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#evaluate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluate(BabyCobolParser.EvaluateContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#remainder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemainder(BabyCobolParser.RemainderContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#giving}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGiving(BabyCobolParser.GivingContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#withnoadvancing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithnoadvancing(BabyCobolParser.WithnoadvancingContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#any_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_expression(BabyCobolParser.Any_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_expression(BabyCobolParser.Arithmetic_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#string_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_expression(BabyCobolParser.String_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#boolean_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expression(BabyCobolParser.Boolean_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#when_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen_block(BabyCobolParser.When_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#atomic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic(BabyCobolParser.AtomicContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyCobolParser#identifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifiers(BabyCobolParser.IdentifiersContext ctx);
}