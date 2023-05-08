package org.babycobol;

import org.antlr.v4.runtime.tree.ParseTree;
import org.babycobol.exception.ExecutionStoppedException;
import org.babycobol.exception.ExitLoopException;
import org.babycobol.exception.GoToException;
import org.babycobol.exception.NextSentenceException;
import org.babycobol.parser.BabyCobolBaseVisitor;
import org.babycobol.parser.BabyCobolParser;

import java.util.*;

// add overrides of visitor functions here
public class BabyCobolCustomVisitor extends BabyCobolBaseVisitor<Object> {
    private final Map<String, Value> variableMap = new HashMap<>();
    private final Map<String, ParseTree> procNames;
    private final VariableParser varParser = new VariableParser();
    private final SignalHelper signalHelper = new SignalHelper();

    public BabyCobolCustomVisitor(Map<String, ParseTree> procNames) {
        this.procNames = procNames;
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
        for (BabyCobolParser.IdentifiersContext i : ctx.identifiers()) {
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

    private void validatePerformProcname(String procName) {
        if (!procNames.containsKey(procName))
            throw new IllegalStateException("Compilation error: there is no sentence with name " + procName);
    }

    public ParseTree getParseTreeFromProcName(String procName) {
        validatePerformProcname(procName);

        return procNames.get(procName);
    }

    @Override
    public Object visitPerform(BabyCobolParser.PerformContext ctx) {
        if (ctx.through() == null)
            return visit(getParseTreeFromProcName(ctx.procname().getText()));
        else {
            List<ParseTree> statements = fetchSentencesBetweenProcNames(ctx.procname().getText(), ctx.through().procname().getText());
            statements.forEach(this::visit);
            return defaultResult();
        }
    }

    private List<ParseTree> fetchSentencesBetweenProcNames(String from, String to) {
        validatePerformProcname(from);
        validatePerformProcname(to);

        List<ParseTree> statements = new ArrayList<>();
        boolean betweenProcnames = false;

        for (Map.Entry<String, ParseTree> entry : procNames.entrySet()) {
            if (entry.getKey().equals(from))
                betweenProcnames = true;

            if (betweenProcnames)
                statements.add(entry.getValue());

            if (entry.getKey().equals(to))
                betweenProcnames = false;
        }

        if (betweenProcnames)
            throw new IllegalStateException("Procname %s does not follow procname %s".formatted(to, from));

        return statements;
    }

    @Override
    public Object visitSignal(BabyCobolParser.SignalContext ctx) {
        if (ctx.off() == null) {
            signalHelper.set(ctx.procname().getText());
        } else {
            signalHelper.unset();
        }

        return defaultResult();
    }

    @Override
    public Object visitGoto(BabyCobolParser.GotoContext ctx) throws GoToException {
        if (variableMap.containsKey(ctx.IDENTIFIER().getText())) {
            String tempProcName = variableMap.get(ctx.IDENTIFIER().getText()).getValue();
            if (procNames.containsKey(tempProcName)) {
                throw new GoToException(tempProcName);
            }
        }
        if (procNames.containsKey(ctx.IDENTIFIER().getText())) {
            throw new GoToException(ctx.IDENTIFIER().getText());
        }
        throw new RuntimeException("Not a valid GO TO target");
    }

    @Override
    public Object visitCall(BabyCobolParser.CallContext ctx) { return visitChildren(ctx); }


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

        return defaultResult();
    }

    @Override
    public Object visitDivide(BabyCobolParser.DivideContext ctx) {
        String key;
        String keyRemainder;
        int newValue;
        int remainder;
        Value valueObj;

        if (ctx.giving() == null) {
            for (int i = 0; i < ctx.identifiers().size(); i++) {
                key = ctx.identifiers().get(i).getText();

                valueObj = variableMap.get(key);
                if (!valueObj.isNumerical()) {
                    throw new RuntimeException("Variable is not numerical");
                }

                if (valueObj.getValue() == null) {
                    throw new RuntimeException("Cannot divide an empty variable");
                } else {
                    newValue = Integer.parseInt(valueObj.getValue());
                }

                newValue /= Integer.parseInt(ctx.divisor.getText().trim());
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
            newValue /= Integer.parseInt(ctx.divisor.getText().trim());
            valueObj.setValue(Integer.toString(newValue));
            variableMap.put(key, valueObj);

            if (ctx.remainder() != null) {
                keyRemainder = ctx.remainder().identifiers().getText();

                valueObj = variableMap.get(keyRemainder);
                if (!valueObj.isNumerical()) {
                    throw new RuntimeException("Variable is not numerical");
                }

                remainder = Integer.parseInt(ctx.base.getText().trim()) % Integer.parseInt(ctx.divisor.getText().trim());
                valueObj.setValue(Integer.toString(remainder));
                variableMap.put(keyRemainder, valueObj);
            }
        }

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

    public String buildSpacesValueBasedOnPicture(String picture) {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < picture.length(); i++) {
            switch (picture.charAt(i)) {
                case '9' -> {
                    value.append('0');
                }
                case 'A', 'X', 'Z', 'S' -> {
                    value.append(' ');
                }
                case 'V' -> {
                    value.append('.');
                }
            }
        }
        return value.toString();
    }

    public String buildHighValueBasedOnPicture(String picture) {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < picture.length(); i++) {
            switch (picture.charAt(i)) {
                case '9', 'Z' -> {
                    value.append('9');
                }
                case 'A' -> {
                    value.append('z');
                }
                case 'X' -> {
                    value.append((char)255);
                }
                case 'S' -> {
                    value.append('+');
                }
                case 'V' -> {
                    value.append('.');
                }
            }
        }
        return value.toString();
    }

    public String buildLowValueBasedOnPicture(String picture) {
        boolean isStartsWithS = picture.startsWith("S");
        boolean isAll9 = true;
        if (isStartsWithS) {
            for (int i = 1; i < picture.length(); i++) {
                if (picture.charAt(i) != '9') {
                    isAll9 = false;
                    break;
                }
            }
        }

        StringBuilder value = new StringBuilder();
        for (int i = 0; i < picture.length(); i++) {
            switch (picture.charAt(i)) {
                case '9' -> {
                    if (isStartsWithS && isAll9) {
                        value.append('9');
                    } else {
                        value.append('0');
                    }
                }
                case 'A', 'Z' -> {
                    value.append(' ');
                }
                case 'X' -> {
                    value.append((char)0);
                }
                case 'S' -> {
                    value.append('-');
                }
                case 'V' -> {
                    value.append('.');
                }
            }
        }
        return value.toString();
    }

    @Override
    public Object visitData_division(BabyCobolParser.Data_divisionContext ctx) {
        if (ctx.variable().size() == 0) {
            return defaultResult();
        }

        String currParent = "";
        int baseLevel = Integer.parseInt(ctx.variable(0).level().getText());
        List<BabyCobolParser.VariableContext> v = ctx.variable();
        for (int i = 0; i < v.size(); i++) {
            if (Integer.parseInt(v.get(i).level().getText()) == baseLevel) {
                currParent = v.get(i).IDENTIFIER().getText();
            }

            String picture = "";
            StringBuilder variable = new StringBuilder(v.get(i).IDENTIFIER().getText());

            if (v.get(i).picture() != null) {
                picture = v.get(i).picture().REPRESENTATION().getText();
            } else if (v.get(i).like() != null) {
                Value likeValue = variableMap.get(v.get(i).like().identifiers().getText());
                if (likeValue != null) {
                    picture = likeValue.getPicture();
                } else {
                    throw new RuntimeException("Variable for LIKE does not exist");
                }
            } else if (i+1 >= v.size() || (i+1 < v.size() && Integer.parseInt(v.get(i+1).level().getText()) == baseLevel)) {
                throw new RuntimeException("Picture not defined");
            }

            if (!Objects.equals(picture, "")) {
                String value = buildSpacesValueBasedOnPicture(picture);
                if (v.get(i).occurs() != null) {
                    int times = Integer.parseInt(v.get(i).occurs().INT().getText());
                    for (int j = 0; j < times; j++) {
                        StringBuilder arrayVariable = new StringBuilder(variable.toString());
                        arrayVariable.append("(").append(j).append(")");
                        if (Integer.parseInt(v.get(i).level().getText()) > baseLevel) {
                            arrayVariable.append("OF").append(currParent);
                        }
                        variableMap.put(arrayVariable.toString(), new Value(value, picture));
                    }
                } else {
                    if (Integer.parseInt(v.get(i).level().getText()) > baseLevel) {
                        variable.append("OF").append(currParent);
                    }
                    variableMap.put(variable.toString(), new Value(value, picture));
                }

            }
        }

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
        int currentChild = 0;
        while (currentChild < ctx.getChildCount()) {
            try {
                visit(ctx.getChild(currentChild));
                currentChild++;
                signalHelper.stop();
            } catch (ExecutionStoppedException | IllegalStateException e) {
                // don't handle compilation and execution exceptions
                // need to introduce a base SyntaxError class
                throw e;
            } catch (GoToException e) {
                currentChild = locateProcName(ctx, e.getMessage());
            } catch (Exception e) {
                if (signalHelper.isSet() && signalHelper.outsideHandler()) {
                    currentChild = locateProcName(ctx, signalHelper.procName());
                    signalHelper.start();
                } else {
                    throw e;
                }
            }
        }
        return defaultResult();
    }

    private static int locateProcName(BabyCobolParser.Procedure_divisionContext ctx, String procName) {
        for (int ip = 0; ip < ctx.getChildCount(); ip++) {
            if (ctx.getChild(ip).getText().startsWith(procName + "."))
                return ip;
        }
        throw new IllegalStateException("Failed to find procname " + procName);
    }

    @Override
    public Object visitMove(BabyCobolParser.MoveContext ctx) {
        String value = "";
        if (ctx.INT() != null) {
            value = ctx.INT().getText();
        } else if (ctx.singlevar() != null) {
            String variableName = varParser.parseSingleVar(ctx.singlevar());
            value = variableMap.get(variableName).getValue();
        }

        List<String> varNames = varParser.parseMultiVar(ctx.multivar().identifiers(), variableMap.keySet());

        if (varNames.isEmpty())
            throw new IllegalStateException("variable names are ambiguous: " + ctx.multivar().identifiers());

        for (String name : varNames) {
            Value currValue = variableMap.get(name);

            if (ctx.SPACES() != null) {
                value = buildSpacesValueBasedOnPicture(currValue.getPicture());
            } else if (ctx.HIGH_VALUES() != null) {
                value = buildHighValueBasedOnPicture(currValue.getPicture());
            } else if (ctx.LOW_VALUES() != null) {
                value = buildLowValueBasedOnPicture(currValue.getPicture());
            } else {
                if (!isConformsToPicture(value, currValue.getPicture())) {
                    throw new RuntimeException("Move value does not match picture");
                }
            }

            currValue.setValue(value);
            variableMap.put(name, currValue);
        }

        return defaultResult();
    }

    boolean passFirstVaryingLoop = false;
    @Override public Object visitLoop(BabyCobolParser.LoopContext ctx) {
        passFirstVaryingLoop = false;
        while (true) {
            try {
                visitChildren(ctx);
            } catch (NextSentenceException | ExitLoopException e) {
                return defaultResult();
            }
        }
    }

    @Override
    public Object visitLoop_varying_expression(BabyCobolParser.Loop_varying_expressionContext ctx) throws ExitLoopException {
        int from = 1, by = 1;
        int to = Integer.MAX_VALUE;
        String loopVar = ctx.identifiers().getText();

        if (ctx.from != null) {
            from = Integer.parseInt(ctx.from.INT().getText());
        }
        if (ctx.to != null) {
            to = Integer.parseInt(ctx.to.INT().getText());
        }
        if (ctx.by != null) {
            by = Integer.parseInt(ctx.by.INT().getText());
        }

        from--;
        to--;

        if (!passFirstVaryingLoop) {
            Value loopVarObj = variableMap.get(loopVar);
            if (!loopVarObj.isNumerical()) {
                throw new RuntimeException("Loop variable is not numerical");
            }

            loopVarObj.setValue(String.valueOf(from));
            variableMap.put(loopVar, loopVarObj);
            passFirstVaryingLoop = true;
        }

        Value loopVarObj = variableMap.get(loopVar);
        if (!loopVarObj.isNumerical()) {
            throw new RuntimeException("Loop variable is not numerical");
        }
        int loopIdx = Integer.parseInt(loopVarObj.getValue());
        if (loopIdx > to) {
            throw new ExitLoopException("Exit Varying Loop");
        }
        loopVarObj.setValue(String.valueOf(loopIdx + by));
        variableMap.put(loopVar, loopVarObj);

        return defaultResult();
    }

    @Override
    public Object visitLoop_while_expression(BabyCobolParser.Loop_while_expressionContext ctx) throws ExitLoopException {
        boolean condition = (boolean)visit(ctx.boolean_expression());
        if (!condition) {
            throw new ExitLoopException("Exit While Loop");
        }
        return defaultResult();
    }

    @Override
    public Object visitLoop_until_expression(BabyCobolParser.Loop_until_expressionContext ctx) throws ExitLoopException {
        boolean condition = (boolean)visit(ctx.boolean_expression());
        if (condition) {
            throw new ExitLoopException("Exit Until Loop");
        }
        return defaultResult();
    }

    @Override
    public Object visitAlter(BabyCobolParser.AlterContext ctx) {
        String name1 = ctx.procname(0).getText();
        if (!procNames.containsKey(name1)) {
            throw new IllegalStateException("There is no sentence with name " + name1);
        }

        String name2 = ctx.procname(1).getText();
        if (!procNames.containsKey(name2)) {
            throw new IllegalStateException("There is no sentence with name " + name2);
        }

        ParseTree proc1 = procNames.get(name1);
        if (proc1.getChild(4) == null) {    // check that ParseTree only contains: [0]procName [1]. [2]statement [3].
            if (proc1.getChild(2).getText().startsWith("GO TO")) {
                // this implementation behaves like a PERFORM
                ParseTree tree = procNames.get(name2);
                procNames.put(name1, tree);
            }
        }

        return defaultResult();
    }
}