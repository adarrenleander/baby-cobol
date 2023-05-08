package org.babycobol;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
class VariableParserTest {

//    @Test void oneVar() {
//        var declaredNames = Set.of("ACCOUNTNUMBER", "NUMBER");
//        var multivar = tokens("ACCOUNT", "NUMBER");
//        List<String> parse = new VariableParser().parseMultiVar(multivar, declaredNames);
//        assertListEquals(List.of("ACCOUNTNUMBER"), parse);
//    }
//
//    @Test void twoVars() {
//        var declaredNames = Set.of("ACCOUNTNUMBER", "NUMBER", "ONE");
//        var multivar = tokens("ACCOUNT", "NUMBER", "ONE");
//        List<String> parse = new VariableParser().parseMultiVar(multivar, declaredNames);
//        assertListEquals(List.of("ACCOUNTNUMBER", "ONE"), parse);
//    }
//
//    @Test void useSpaceToDisambiguaate() {
//        var declaredNames = Set.of("ACCOUNTNUMBER", "ACCOUNT", "NUMBER");
//        var multivar = tokens("ACCOUNT", "NUMBER");
//        List<String> parse = new VariableParser().parseMultiVar(multivar, declaredNames);
//        assertListEquals(List.of("ACCOUNT", "NUMBER"), parse);
//    }
//
//    @Test void impossibleToDisambiguate() {
//        var declaredNames = Set.of("ACCOUNTNUMBER", "ACCOUNT", "NUMBER");
//        var multivar = tokens("ACCOUNT", "NUM", "BER");
//        List<String> parse = new VariableParser().parseMultiVar(multivar, declaredNames);
//        assertListEquals(List.of(), parse);
//    }

    static List<? extends TerminalNode> tokens(String... names) {
        return Arrays.stream(names)
                .map(n -> new TerminalNodeImpl(new CommonToken(0, n)))
                .toList();
    }

    static <T> void assertListEquals(List<T> expected, List<T> actual) {
        assertEquals(asString(expected), asString(actual));
    }

    private static <T> String asString(List<T> list) {
        return list.stream()
                .map(e -> Objects.toString(e, ""))
                .collect(Collectors.joining("\n"));
    }
}
