package org.babycobol;

import org.antlr.v4.runtime.*;
import org.babycobol.exception.ExecutionStoppedException;
import org.babycobol.parser.BabyCobolLexer;
import org.babycobol.parser.BabyCobolParser;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // this is our interpreter
        try {
            CharStream input = CharStreams.fromFileName("src/main/main.bcbl");
            BabyCobolLexer lexer = new BabyCobolLexer(input);

            BabyCobolParser parser = new BabyCobolParser(new CommonTokenStream(lexer));
            BabyCobolCustomListener listener = new BabyCobolCustomListener();
            parser.addParseListener(listener);
            parser.addErrorListener(new SyntaxErrorReporter());

            BabyCobolParser.ProgramContext program = parser.program();

            BabyCobolCustomVisitor visitor = new BabyCobolCustomVisitor(listener.getProcNames());
            visitor.visit(program);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (ExecutionStoppedException ex) {
            logger.log(Level.FINE, "execution stopped");
        }
    }

    private static class SyntaxErrorReporter extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            throw new RuntimeException(msg, e);
        }
    }
}
