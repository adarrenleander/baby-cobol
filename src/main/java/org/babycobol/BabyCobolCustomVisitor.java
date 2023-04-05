package org.babycobol;

import gen.babycobol.BabyCobolBaseVisitor;
import gen.babycobol.BabyCobolParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.babycobol.exception.ExecutionStoppedException;
import org.babycobol.exception.NextSentenceException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// add overrides of visitor functions here
public class BabyCobolCustomVisitor extends BabyCobolBaseVisitor<Object> {
    private final Map<String, Integer> variableMap = new HashMap<>();
    private final Map<String, ParseTree> procNames;

    public BabyCobolCustomVisitor(Map<String, ParseTree> procNames) {
        this.procNames = procNames;
    }

    @Override
    public Object visitAccept(BabyCobolParser.AcceptContext ctx) {
        Scanner sc = new Scanner(System.in);
        for (BabyCobolParser.IdentifiersContext i : ctx.identifiers()) {
            if (variableMap.containsKey(i.getText())) {
                variableMap.put(i.getText(), Integer.parseInt(sc.next()));
            } else {
                throw new RuntimeException("Variable not found");
            }
        }
        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Object visitAdd(BabyCobolParser.AddContext ctx) {
        String key;
        int newObject = 0;

        if (ctx.giving() == null) {
            newObject = variableMap.get(ctx.identifiers().getText());
            key = ctx.identifiers().getText();
        } else {
            key = ctx.giving().identifiers().getText();
        }

        for (int i = 0; i < ctx.INT().size(); i++) {
            newObject += Integer.parseInt(ctx.INT(i).getText().trim());
        }
        variableMap.put(key, newObject);

        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Object visitSubtract(BabyCobolParser.SubtractContext ctx) {
        String key;
        int newObject;
        int limit = ctx.INT().size();

        if (ctx.giving() == null) {
            key = ctx.identifiers().getText();
            newObject = variableMap.get(ctx.identifiers().getText());
        } else {
            key = ctx.giving().identifiers().getText();
            newObject = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim());
            limit -= 1;
        }

        for (int i = 0; i < limit; i++) {
            newObject -= Integer.parseInt(ctx.INT(i).getText().trim());
        }
        variableMap.put(key, newObject);

        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Object visitDisplay(BabyCobolParser.DisplayContext ctx) {
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
    public Object visitStop(BabyCobolParser.StopContext ctx) {
        throw new ExecutionStoppedException("Stopped");
    }

    @Override
    public Object visitPerform(BabyCobolParser.PerformContext ctx) {
        String name = ctx.procname().getText();
        if (!procNames.containsKey(name))
            throw new IllegalStateException("Compilation error: there is no sentence with name " + name);

        return visit(procNames.get(name));
    }

    @Override
    public Object visitMultiply(BabyCobolParser.MultiplyContext ctx) {
        String key;
        int newObject;
        int limit = ctx.identifiers().size();

        if (ctx.giving() == null) {
            for (int i = 0; i < limit; i++) {
                key = ctx.identifiers(i).getText();
                newObject = variableMap.get(ctx.identifiers(i).getText());
                newObject *= Integer.parseInt(ctx.INT(0).getText().trim());
                variableMap.put(key, newObject);
            }
        } else {
            key = ctx.giving().identifiers().getText();
            newObject = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim());
            newObject *= Integer.parseInt(ctx.INT(0).getText().trim());
            variableMap.put(key, newObject);
        }
        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Object visitDivide(BabyCobolParser.DivideContext ctx) {
        String key;
        String keyRemainder;
        int remainder;
        int newObject;
        int limit = ctx.identifiers().size();

        if (ctx.remainder() == null){
            if (ctx.giving() == null) {
                for (int i = 0; i < limit; i++) {
                    key = ctx.identifiers().get(i).getText();
                    newObject = variableMap.get(ctx.identifiers().get(i).getText());
                    newObject /= Integer.parseInt(ctx.INT(0).getText().trim());
                    variableMap.put(key, newObject);
                }
            } else {
                key = ctx.giving().identifiers().getText();
                newObject = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim());
                newObject /= Integer.parseInt(ctx.INT(0).getText().trim());
                variableMap.put(key, newObject);
            }
        } else {
            key = ctx.giving().identifiers().getText();
            newObject = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim());
            newObject /= Integer.parseInt(ctx.INT(0).getText().trim());
            variableMap.put(key, newObject);
            keyRemainder = ctx.remainder().identifiers().getText();
            remainder = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim()) % Integer.parseInt(ctx.INT(0).getText().trim());
            variableMap.put(keyRemainder, remainder);
        }

        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Object visitIf(BabyCobolParser.IfContext ctx) {
        boolean condition = (boolean)visit(ctx.boolean_expression());
        if (condition) {
            for (BabyCobolParser.StatementContext s : ctx.i) {
                visit(s);
            }
        } else {
            if (ctx.e != null) {
                for (BabyCobolParser.StatementContext s : ctx.e) {
                    visit(s);
                }
            }
        }
        return defaultResult();
    }

    @Override
    public Object visitEvaluate(BabyCobolParser.EvaluateContext ctx) {
        Object condition = visit(ctx.any_expression());

        for (BabyCobolParser.When_blockContext w : ctx.when_block()) {
            if (w.atomic() != null) {
                if (condition.toString().equals(w.atomic().getText())) {
                    for (BabyCobolParser.StatementContext s : w.statement()) {
                        visit(s);
                    }
                    return defaultResult();
                }
            } else {
                for (BabyCobolParser.StatementContext s : w.statement()) {
                    visit(s);
                }
                return defaultResult();
            }
        }

        return defaultResult();
    }

    @Override
    public Object visitBoolean_expression(BabyCobolParser.Boolean_expressionContext ctx) {
        if (ctx.getText().equals("TRUE")) {
            return true;
        }
        if (ctx.getText().equals("FALSE")) {
            return false;
        }

        if (ctx.arithmetic_expression() != null) {
            int left = (int)visit(ctx.arithmetic_expression(0));
            int right = (int)visit(ctx.arithmetic_expression(1));

            switch (ctx.COMPARISON_OPERATOR().getText()) {
                case "=" -> {
                    return left == right;
                }
                case ">" -> {
                    return left > right;
                }
                case "<" -> {
                    return left < right;
                }
                case ">=" -> {
                    return left >= right;
                }
                case "<=" -> {
                    return left <= right;
                }
            }
        }

        if (ctx.getText().startsWith("NOT")) {
            return !(boolean)visit(ctx.boolean_expression(0));
        }

        if (ctx.boolean_expression() != null) {
            Boolean left = (boolean)visit(ctx.boolean_expression(0));
            Boolean right = (boolean)visit(ctx.boolean_expression(1));
            switch (ctx.BOOLEAN_OPERATOR().getText()) {
                case "OR" -> {
                    return left || right;
                }
                case "AND" -> {
                    return left && right;
                }
                case "XOR" -> {
                    return left ^ right;
                }
            }
        }

        return defaultResult();
    }

    @Override
    public Object visitArithmetic_expression(BabyCobolParser.Arithmetic_expressionContext ctx) {
        if (ctx.atomic() != null) {
            if (ctx.atomic().INT() != null) {
                return Integer.parseInt(ctx.atomic().INT().getText());
            }
            return variableMap.get(ctx.atomic().identifiers().getText());
        }

        Integer left = (int)visit(ctx.arithmetic_expression(0));
        Integer right = (int)visit(ctx.arithmetic_expression(1));
        switch (ctx.ARITHMETIC_OPERATOR().getText()) {
            case "+" -> {
                return left + right;
            }
            case "-" -> {
                return left - right;
            }
            case "*" -> {
                return left * right;
            }
            case "/" -> {
                return left / right;
            }
            case "**" -> {
                return Math.pow(left, right);
            }
        }

        return defaultResult();
    }

    @Override
    public Object visitData_divison(BabyCobolParser.Data_divisonContext ctx) {
        for (BabyCobolParser.VariableContext v : ctx.variable()) {
            if (v.occurs() != null) {
                int times = Integer.parseInt(v.occurs().INT().getText());
                for (int i = 0; i < times; i++) {
                    variableMap.put(v.IDENTIFIER().getText()+"["+i+"]", 0);
                }
            } else {
                variableMap.put(v.IDENTIFIER().getText(), 0);
            }
        }
        System.out.println(variableMap);
        return defaultResult();
    }

    @Override
    public Object visitNext_sentence(BabyCobolParser.Next_sentenceContext ctx) throws NextSentenceException {
        throw new NextSentenceException("Next sentence triggered");
    }

    @Override
    public Object visitSentence(BabyCobolParser.SentenceContext ctx) {
        try {
            visitChildren(ctx);
        } catch (NextSentenceException e) {
            return defaultResult();
        }
        return defaultResult();
    }

    @Override
    public Object visitMove(BabyCobolParser.MoveContext ctx) {
        String token = ctx.getChild(1).getText();
        int value;
        if (Character.isAlphabetic(token.codePointAt(0))) {

            value = variableMap.get(token);
        } else {
            value = Integer.parseInt(token);
        }

        for (int idx = 3; idx < ctx.getChildCount(); idx++) {
            token = ctx.getChild(idx).getText();
            variableMap.put(token, value);
        }
        //System.out.println(variableMap);
        return defaultResult();
    }

    boolean passFirstVaryingLoop = false;
    @Override public Object visitLoop(BabyCobolParser.LoopContext ctx) {
        passFirstVaryingLoop = false;
        while (true) {
            try {
                visitChildren(ctx);
            } catch (NextSentenceException e) {
                return defaultResult();
            }
        }
    }

    @Override
    public Object visitLoop_varying_expression(BabyCobolParser.Loop_varying_expressionContext ctx) throws NextSentenceException {
        int from = 1, by = 1;
        int to = Integer.MAX_VALUE;

        if (ctx.from != null) {
            from = Integer.parseInt(ctx.from.INT().getText());
        }
        if (ctx.to != null) {
            to = Integer.parseInt(ctx.to.INT().getText());
        }
        if (ctx.by != null) {
            by = Integer.parseInt(ctx.by.INT().getText());
        }

        String loopVar = ctx.identifiers().getText();

        if (!passFirstVaryingLoop) {
            variableMap.put(loopVar, from);
            passFirstVaryingLoop = true;
        }

        int loopIdx = variableMap.get(loopVar);
        if (loopIdx > to) {
            throw new NextSentenceException("Exit Varying Loop");
        }
        variableMap.put(loopVar, loopIdx + by);

        return defaultResult();
    }

    @Override
    public Object visitLoop_while_expression(BabyCobolParser.Loop_while_expressionContext ctx) throws NextSentenceException {
        boolean condition = (boolean)visit(ctx.boolean_expression());
        if (!condition) {
            throw new NextSentenceException("Exit While Loop");
        }
        return defaultResult();
    }

    @Override
    public Object visitLoop_until_expression(BabyCobolParser.Loop_until_expressionContext ctx) {
        boolean condition = (boolean)visit(ctx.boolean_expression());
        if (condition) {
            throw new NextSentenceException("Exit Until Loop");
        }
        return defaultResult();
    }
}