package org.babycobol;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.babycobol.parser.BabyCobolParser;

import java.util.*;
import java.util.stream.Collectors;

public class VariableParser {

    public String parseSingleVar(BabyCobolParser.SinglevarContext singlevar) {
        return singlevar.VAR().stream()
                .map(ParseTree::getText)
                .collect(Collectors.joining(""));
    }

    public List<String> parseMultiVar(List<? extends TerminalNode> multivar, Collection<String> declaredNames) {
        Map<Integer, List<Integer>> matches = new HashMap<>();
        matches.put(0, new ArrayList<>()); // position 0 has no matches

        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1); // sentinel

        StringBuilder combined = new StringBuilder();
        int position = 0;

        List<String> varNames = multivar.stream().map(ParseTree::getText).toList();

        for (String name : varNames) {
            combined.append(name);
            position += name.length();

            var currentMatches = new ArrayList<Integer>();
            matches.put(position, currentMatches);

            for (Map.Entry<Integer, Integer> e : new HashSet<>(counts.entrySet())) {
                int previous = e.getKey();
                if (declaredNames.contains(combined.substring(previous, position))){
                    currentMatches.add(previous);
                    counts.merge(position, e.getValue(), Integer::sum);
                }
            }
        }

        if (counts.get(combined.length()) == 1) {
            return singleMatch(matches, combined.toString());
        } else if (counts.get(combined.length()) > 1 && declaredNames.containsAll(varNames)) {
            return varNames;
        }

        return List.of();
    }

    private List<String> singleMatch(Map<Integer, List<Integer>> matches, String combined) {
        List<String> result = new ArrayList<>();
        int current = combined.length();

        while (!matches.get(current).isEmpty()) {
            List<Integer> precedingPositions = matches.get(current);
            assert precedingPositions.size() == 1;

            Integer previous = precedingPositions.get(0);

            result.add(combined.substring(previous, current));

            current = previous;
        }

        Collections.reverse(result);

        return result;
    }
}
