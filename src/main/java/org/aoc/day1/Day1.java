package org.aoc.day1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Day1 {
    public int distance(Collection<Integer> firstColumn, Collection<Integer> secondColumn) {
        if(firstColumn.isEmpty() || secondColumn.isEmpty()) {
            return 0;
        }
        List<Integer> column1 = new ArrayList<>(firstColumn);
        List<Integer> column2 = new ArrayList<>(secondColumn);
        column1.sort(Integer::compareTo);
        column2.sort(Integer::compareTo);

        int distance = 0;
        for (int i = 0; i < column1.size(); i++) {
            distance += Math.abs(column1.get(i) - column2.get(i));
        }
        return distance;
    }

    public int similarity(Collection<Integer> firstColumn, Collection<Integer> secondColumn) {
        if(firstColumn.isEmpty() || secondColumn.isEmpty()) {
            return 0;
        }
        Map<Integer, Long> frequency = secondColumn.stream().collect(groupingBy(Function.identity(), counting()));

        return firstColumn.stream().mapToInt(i -> i * frequency.getOrDefault(i, 0L).intValue()).sum();
    }
}
