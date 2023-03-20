package org.babycobol;

import org.babycobol.parser.BabyCobolBaseListener;
import org.babycobol.parser.BabyCobolParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

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
}
