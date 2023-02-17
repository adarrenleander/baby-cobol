package org.babycobol;

import gen.babycobol.BabyCobolLexer;
import gen.babycobol.BabyCobolParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // this is our compiler
        try {
            CharStream input = CharStreams.fromFileName("src/main/main.bcbl");
            BabyCobolLexer lexer = new BabyCobolLexer(input);
            BabyCobolParser parser = new BabyCobolParser(new CommonTokenStream(lexer));
            parser.addParseListener(new BabyCobolCustomListener());
            parser.program();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}