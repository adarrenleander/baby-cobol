package org.babycobol;

import gen.babycobol.BabyCobolBaseListener;
import gen.babycobol.BabyCobolParser;

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
        variableMap.put(ctx.VAR().getText(), variableMap.get(ctx.VAR().getText()) + Integer.parseInt(ctx.INT().getText().trim()));
        System.out.println(variableMap.toString());
    }

    @Override public void exitSubtract(BabyCobolParser.SubtractContext ctx) {
        variableMap.put(ctx.VAR().getText(),  variableMap.get(ctx.VAR().getText()) - Integer.parseInt(ctx.INT().getText().trim()));
        System.out.println(variableMap.toString());
    }
}
