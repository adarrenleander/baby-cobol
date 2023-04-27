package org.babycobol;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.babycobol.exception.ExecutionStoppedException;
import org.babycobol.exception.GoToException;
import org.babycobol.exception.NextSentenceException;
import org.babycobol.parser.BabyCobolBaseVisitor;
import org.babycobol.parser.BabyCobolParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// add overrides of visitor functions here
public class BabyCobolCustomVisitor extends BabyCobolBaseVisitor<Object> {
    private final Map<String, Value> variableMap = new HashMap<>();
    private final Map<String, ParseTree> procNames;
    private final VariableParser varParser = new VariableParser();

    public BabyCobolCustomVisitor(Map<String, ParseTree> procNames) {
        this.procNames = procNames;
    }

    // TODO: delete this
    public void printVariableMap() {
        for (String key : variableMap.keySet()) {
            System.out.print(key + " = " + variableMap.get(key).getValue() + ", ");
        }
        System.out.println();
    }

    public Boolean isConformsToPicture(String value, String picture) {
        if (value.length() != picture.length()) {
            return false;
        }

        for (int i = 0; i < picture.length(); i++) {
            Character c = value.charAt(i);

            switch (picture.charAt(i)) {
                case '9', 'Z' -> {   // any numerical digit
                    try {
                        Integer.parseInt(String.valueOf(c));
                    } catch (Exception e) {
                        return false;
                    }
                }
                case 'A' -> {   // any alphabetical character or whitespace
                    if (!Character.isAlphabetic(c)) {
                        return false;
                    }
                }
                case 'S' -> {   // a sign, positive or negative, space is treated as a plus
                    if (c.compareTo('+') != 0 && c.compareTo('-') != 0 && c.compareTo(' ') != 0) {
                        return false;
                    }
                }
                case 'V' -> {   // a decimal separator (usually . or ,)
                    if (c.compareTo('.') != 0 && c.compareTo(',') != 0) {
                        return false;
                    }
                }
                // case 'X':   // any single character -> unhandled bcos can accept any character
            }
        }

        return true;
    }

    @Override
    public Object visitAccept(BabyCobolParser.AcceptContext ctx) {
        Scanner sc = new Scanner(System.in);
        for (TerminalNode i : ctx.IDENTIFIER()) {
            if (variableMap.containsKey(i.getText())) {
                Value currValue = variableMap.get(i.getText());
                Value newValue = new Value(sc.next(), currValue.getPicture());
                if (isConformsToPicture(newValue.getValue(), currValue.getPicture())) {
                    variableMap.put(i.getText(), newValue);
                } else {
                    throw new RuntimeException("Value does not match picture");
                }
            } else {
                throw new RuntimeException("Variable not found");
            }
        }

        printVariableMap();
        return defaultResult();
    }

    @Override
    public Object visitAdd(BabyCobolParser.AddContext ctx) {
        String key;
        Value valueObj;
        int newValue;

        if (ctx.giving() != null) {
            key = ctx.giving().identifiers().getText();
        } else {
            key = ctx.identifiers().getText();
        }

        valueObj = variableMap.get(key);
        if (!valueObj.isNumerical()) {
            throw new RuntimeException("Variable is not numerical");
        }

        if (ctx.giving() != null) {
            newValue = Integer.parseInt(ctx.base.getText().trim());
        } else {
            if (valueObj.getValue() == null) {
                newValue = 0;
            } else {
                newValue = Integer.parseInt(valueObj.getValue());
            }
        }

        for (int i = 0; i < ctx.additions.size(); i++) {
            newValue += Integer.parseInt(ctx.additions.get(i).getText().trim());
        }
        valueObj.setValue(Integer.toString(newValue));
        variableMap.put(key, valueObj);

        printVariableMap();
        return defaultResult();
    }

    @Override
    public Object visitSubtract(BabyCobolParser.SubtractContext ctx) {
        String key;
        Value valueObj;
        int newValue;

        if (ctx.giving() != null) {
            key = ctx.giving().identifiers().getText();
        } else {
            key = ctx.identifiers().getText();
        }

        valueObj = variableMap.get(key);
        if (!valueObj.isNumerical()) {
            throw new RuntimeException("Variable is not numerical");
        }

        if (ctx.giving() != null) {
            newValue = Integer.parseInt(ctx.base.getText().trim());
        } else {
            if (valueObj.getValue() == null) {
                newValue = 0;
            } else {
                newValue = Integer.parseInt(valueObj.getValue());
            }
        }

        if (!valueObj.isNumerical()) {
            throw new RuntimeException("Variable is not numerical");
        }

        for (int i = 0; i < ctx.subtractors.size(); i++) {
            newValue -= Integer.parseInt(ctx.subtractors.get(i).getText().trim());
        }
        valueObj.setValue(Integer.toString(newValue));
        variableMap.put(key, valueObj);

        printVariableMap();
        return defaultResult();
    }

    @Override
    public Object visitDisplay(BabyCobolParser.DisplayContext ctx) {
        int size = ctx.withnoadvancing() == null ? ctx.getChildCount() : ctx.getChildCount() - 1;
        for (int idx = 1; idx < size; idx++) {
            String token = ctx.getChild(idx).getText();

            if (Character.isAlphabetic(token.codePointAt(0))) {
                System.out.print(variableMap.get(token).getValue());
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

    public ParseTree getParseTreeFromProcName(String procName) {
        if (!procNames.containsKey(procName))
            throw new IllegalStateException("Compilation error: there is no sentence with name " + procName);

        return procNames.get(procName);
    }

    @Override
    public Object visitPerform(BabyCobolParser.PerformContext ctx) {
        return visit(getParseTreeFromProcName(ctx.procname().getText()));
    }

    @Override
    public Object visitGoto(BabyCobolParser.GotoContext ctx) throws GoToException {
        throw new GoToException(ctx.procname().getText());
    }

    @Override
    public Object visitMultiply(BabyCobolParser.MultiplyContext ctx) {
        String key;
        Value valueObj;
        int newValue;

        if (ctx.giving() == null) {
            for (int i = 0; i < ctx.identifiers().size(); i++) {
                key = ctx.identifiers(i).getText();

                valueObj = variableMap.get(key);
                if (!valueObj.isNumerical()) {
                    throw new RuntimeException("Variable is not numerical");
                }

                if (valueObj.getValue() == null) {
                    newValue = 0;
                } else {
                    newValue = Integer.parseInt(valueObj.getValue());
                }

                newValue *= Integer.parseInt(ctx.multiplier.getText().trim());
                valueObj.setValue(Integer.toString(newValue));
                variableMap.put(key, valueObj);
            }
        } else {
            key = ctx.giving().identifiers().getText();

            valueObj = variableMap.get(key);
            if (!valueObj.isNumerical()) {
                throw new RuntimeException("Variable is not numerical");
            }

            newValue = Integer.parseInt(ctx.base.getText().trim());
            newValue *= Integer.parseInt(ctx.multiplier.getText().trim());
            valueObj.setValue(Integer.toString(newValue));
            variableMap.put(key, valueObj);
        }

        printVariableMap();
        return defaultResult();
    }

//    @Override
//    public Object visitDivide(BabyCobolParser.DivideContext ctx) {
//        String key;
//        String keyRemainder;
//        int remainder;
//        int newObject;
//        int limit = ctx.identifiers().size();
//
//        if (ctx.remainder() == null){
//            if (ctx.giving() == null) {
//                for (int i = 0; i < limit; i++) {
//                    key = ctx.identifiers().get(i).getText();
//                    newObject = variableMap.get(ctx.identifiers().get(i).getText());
//                    newObject /= Integer.parseInt(ctx.INT(0).getText().trim());
//                    variableMap.put(key, newObject);
//                }
//            } else {
//                key = ctx.giving().identifiers().getText();
//                newObject = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim());
//                newObject /= Integer.parseInt(ctx.INT(0).getText().trim());
//                variableMap.put(key, newObject);
//            }
//        } else {
//            key = ctx.giving().identifiers().getText();
//            newObject = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim());
//            newObject /= Integer.parseInt(ctx.INT(0).getText().trim());
//            variableMap.put(key, newObject);
//            keyRemainder = ctx.remainder().identifiers().getText();
//            remainder = Integer.parseInt(ctx.INT(ctx.INT().size()-1).getText().trim()) % Integer.parseInt(ctx.INT(0).getText().trim());
//            variableMap.put(keyRemainder, remainder);
//        }
//
//        System.out.println(variableMap);
//        return defaultResult();
//    }

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
            return Integer.parseInt(variableMap.get(ctx.atomic().identifiers().getText()).getValue());
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
    public Object visitData_division(BabyCobolParser.Data_divisionContext ctx) {
        for (BabyCobolParser.VariableContext v : ctx.variable()) {
            String variable = v.IDENTIFIER().getText();
            String picture = v.picture().REPRESENTATION().getText();

            if (v.occurs() != null) {
                int times = Integer.parseInt(v.occurs().INT().getText());
                for (int i = 0; i < times; i++) {
                    variableMap.put(variable+"["+i+"]", new Value(null, picture));
                }
            } else {
                variableMap.put(variable, new Value(null, picture));
            }
        }

        printVariableMap();
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
    public Object visitProcedure_division(BabyCobolParser.Procedure_divisionContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            try {
                visit(ctx.getChild(i));
            } catch (GoToException e) {
                for (int j = 0; j < ctx.getChildCount(); j++) {
                    if (ctx.getChild(j).getText().startsWith(e.getMessage() + ".")) {
                        i = j;
                    }
                }
                visit(getParseTreeFromProcName(e.getMessage()));
            }
        }
        return defaultResult();
    }

//    @Override
//    public Object visitMove(BabyCobolParser.MoveContext ctx) {
//
//        int value;
//        if (ctx.INT() == null) {
//            String variableName = varParser.parseSingleVar(ctx.singlevar());
//            value = variableMap.get(variableName);
//        } else {
//            value = Integer.parseInt(ctx.INT().getText());
//        }
//
//        List<String> varNames = varParser.parseMultiVar(ctx.multivar().IDENTIFIER(), variableMap.keySet());
//
//        if (varNames.isEmpty())
//            throw new IllegalStateException("variable names are ambiguous: " + ctx.multivar().IDENTIFIER());
//
//        for (String name : varNames) {
//            variableMap.put(name, value);
//        }
//
//        //System.out.println(variableMap);
//        return defaultResult();
//    }

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

//    @Override
//    public Object visitLoop_varying_expression(BabyCobolParser.Loop_varying_expressionContext ctx) throws NextSentenceException {
//        int from = 1, by = 1;
//        int to = Integer.MAX_VALUE;
//
//        if (ctx.from != null) {
//            from = Integer.parseInt(ctx.from.INT().getText());
//        }
//        if (ctx.to != null) {
//            to = Integer.parseInt(ctx.to.INT().getText());
//        }
//        if (ctx.by != null) {
//            by = Integer.parseInt(ctx.by.INT().getText());
//        }
//
//        String loopVar = ctx.identifiers().getText();
//
//        if (!passFirstVaryingLoop) {
//            variableMap.put(loopVar, from);
//            passFirstVaryingLoop = true;
//        }
//
//        int loopIdx = variableMap.get(loopVar);
//        if (loopIdx > to) {
//            throw new NextSentenceException("Exit Varying Loop");
//        }
//        variableMap.put(loopVar, loopIdx + by);
//
//        return defaultResult();
//    }

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