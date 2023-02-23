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
	 * Visit a parse tree produced by {@link BabyCobolParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(BabyCobolParser.StatementsContext ctx);
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
	 * Visit a parse tree produced by {@link BabyCobolParser#giving}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGiving(BabyCobolParser.GivingContext ctx);
}