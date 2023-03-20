package org.babycobol;

import org.antlr.v4.runtime.RecognitionException;
import org.babycobol.parser.BabyCobolBaseVisitor;
import org.babycobol.parser.BabyCobolParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// add overrides of visitor functions here
public class BabyCobolCustomVisitor extends BabyCobolBaseVisitor<Void> {
    private final Map<String, Integer> variableMap = new HashMap<>();
    private final Map<String, ParseTree> procNames;
    private final VariableParser varParser = new VariableParser();

    public BabyCobolCustomVisitor(Map<String, ParseTree> procNames) {
        this.procNames = procNames;
    }

    @Override
    public Void visitAccept(BabyCobolParser.AcceptContext ctx) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ctx.VAR().size(); i++) {
            variableMap.put(ctx.VAR().get(i).getText(), Integer.parseInt(sc.next()));
        }
        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Void visitAdd(BabyCobolParser.AddContext ctx) {
        String key;
        int newValue = 0;

        if (ctx.giving() == null) {
            key = ctx.singlevar().getText();
            newValue = variableMap.get(key);
        } else {
            key = ctx.giving().singlevar().getText();
        }

        for (int i = 0; i < ctx.INT().size(); i++) {
            newValue += Integer.parseInt(ctx.INT().get(i).getText().trim());
        }
        variableMap.put(key, newValue);

        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Void visitSubtract(BabyCobolParser.SubtractContext ctx) {
        String key;
        int newValue;
        int limit = ctx.INT().size();

        if (ctx.giving() == null) {
            key = ctx.VAR().getText();
            newValue = variableMap.get(ctx.VAR().getText());
        } else {
            key = ctx.giving().singlevar().getText();
            newValue = Integer.parseInt(ctx.INT().get(ctx.INT().size()-1).getText().trim());
            limit -= 1;
        }

        for (int i = 0; i < limit; i++) {
            newValue -= Integer.parseInt(ctx.INT().get(i).getText().trim());
        }
        variableMap.put(key, newValue);

        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Void visitDisplay(BabyCobolParser.DisplayContext ctx) {
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

        return defaultResult();
    }

    @Override
    public Void visitStop(BabyCobolParser.StopContext ctx) {
        throw new ExectionStoppedException("Stopped");
    }

    @Override
    public Void visitPerform(BabyCobolParser.PerformContext ctx) {
        String name = ctx.procname().getText();
        if (!procNames.containsKey(name))
            throw new IllegalStateException("Compilation error: there is no sentence with name " + name);

        return visit(procNames.get(name));
    }

    @Override
    public Void visitMove(BabyCobolParser.MoveContext ctx) {

        int value;
        if (ctx.INT() == null) {
            String variableName = varParser.parseSingleVar(ctx.singlevar());
            value = variableMap.get(variableName);
        } else {
            value = Integer.parseInt(ctx.INT().getText());
        }

        List<String> varNames = varParser.parseMultiVar(ctx.multivar().VAR(), variableMap.keySet());

        if (varNames.isEmpty())
            throw new IllegalStateException("variable names are ambiguous: " + ctx.multivar().VAR());

        for (String name : varNames) {
            variableMap.put(name, value);
        }

        //System.out.println(variableMap);
        return defaultResult();
    }
}
