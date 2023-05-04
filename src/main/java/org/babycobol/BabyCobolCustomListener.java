package org.babycobol;

import org.antlr.v4.runtime.tree.ParseTree;
import org.babycobol.parser.BabyCobolBaseListener;
import org.babycobol.parser.BabyCobolParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// add overrides of listener functions here
public class BabyCobolCustomListener extends BabyCobolBaseListener {
    private final Map<String, ParseTree> procNames =  new HashMap<>();

    public Map<String, ParseTree> getProcNames() {
        return procNames;
    }

    @Override
    public void exitSentence(BabyCobolParser.SentenceContext tree) {
        if (tree.procname() != null) {
            String name = tree.procname().getText();
            procNames.put(name, tree);
        }
    }

    @Override
    public void exitCopy(BabyCobolParser.CopyContext ctx) {
        ArrayList<String> fileContent = new ArrayList<>();

        try {
            File f = new File("src/main/" + ctx.LITERAL().getText().replaceAll("\"", ""));
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                fileContent.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("An error occurred when opening the file.");
        }

        for (String s : fileContent) {
            if (ctx.replacing() != null) {
                for (BabyCobolParser.ReplacementsContext r : ctx.replacing().replacements()) {
                    String toBeReplaced = r.COPY_LITERAL(0).getText().replaceAll("=", "");
                    String toReplaceWith = r.COPY_LITERAL(1).getText().replaceAll("=", "");
                    s = s.replaceAll(toBeReplaced, toReplaceWith);
                }
            }
            System.out.println(s);
        }
    }
}
