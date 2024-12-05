package org.aoc.day5;

import java.util.*;

import static java.util.Collections.emptySet;

public class Day5 {

    public int sumOfCentralElements(Map<Integer, Set<Integer>> orderingRules, List<List<Integer>> updateLine) {
        return updateLine.stream()
                .filter(line -> respectsOrderingRules(orderingRules, line))
                .mapToInt(this::getCentralElement)
                .sum();
    }

    private boolean respectsOrderingRules(Map<Integer, Set<Integer>> orderingRules, List<Integer> line) {
        for(int i=0; i<line.size()-1; i++) {
            for(int j=i+1; j<line.size(); j++) {
                if(! orderingRules.getOrDefault(line.get(i), emptySet()).contains(line.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getCentralElement(List<Integer> line) {
        return line.get(line.size() / 2);
    }
}
