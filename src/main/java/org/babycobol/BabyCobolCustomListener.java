package org.babycobol;

import gen.babycobol.BabyCobolBaseListener;
import gen.babycobol.BabyCobolParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Scanner;

// add overrides of listener functions here
public class BabyCobolCustomListener extends BabyCobolBaseListener {
    HashMap<String, Integer> variableMap = new HashMap<>();

    @Override public void exitAccept(BabyCobolParser.AcceptContext ctx) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ctx.VAR().size(); i++) {
            variableMap.put(ctx.VAR().get(i).getText(), Integer.parseInt(sc.next()));
        }
        System.out.println(variableMap.toString());
    }

    @Override public void exitAdd(BabyCobolParser.AddContext ctx) {
        String key;
        int newValue = 0;

        if (ctx.giving() == null) {
            newValue = variableMap.get(ctx.VAR().getText());
            key = ctx.VAR().getText();
        } else {
            key = ctx.giving().VAR().getText();
        }

        for (int i = 0; i < ctx.INT().size(); i++) {
            newValue += Integer.parseInt(ctx.INT().get(i).getText().trim());
        }
        variableMap.put(key, newValue);

        System.out.println(variableMap);
    }

    @Override public void exitSubtract(BabyCobolParser.SubtractContext ctx) {
        String key;
        int newValue;
        int limit = ctx.INT().size();

        if (ctx.giving() == null) {
            key = ctx.VAR().getText();
            newValue = variableMap.get(ctx.VAR().getText());
        } else {
            key = ctx.giving().VAR().getText();
            newValue = Integer.parseInt(ctx.INT().get(ctx.INT().size()-1).getText().trim());
            limit -= 1;
        }

        for (int i = 0; i < limit; i++) {
            newValue -= Integer.parseInt(ctx.INT().get(i).getText().trim());
        }
        variableMap.put(key, newValue);

        System.out.println(variableMap);
    }

    @Override
    public void exitDisplay(BabyCobolParser.DisplayContext ctx) {
        int size = ctx.withnoadvancing() == null ? ctx.getChildCount() : ctx.getChildCount() - 1;
        for (int idx = 1; idx < size; idx++) {
            String token = ctx.getChild(idx).getText();

            if (Character.isAlphabetic(token.codePointAt(0))) {
                System.out.print(variableMap.get(token));
                System.out.print(" ");
            } else {
                System.out.print(token);
                System.out.print(" ");
            }
        }

        if (ctx.withnoadvancing() == null)
            System.out.println();

    }

    @Override
    public void exitStop(BabyCobolParser.StopContext ctx) {
        System.exit(0);
    }
}
