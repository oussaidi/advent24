package org.aoc;

import org.aoc.day5.Day5;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.stream.Collectors.*;

class Day5Test {

    @Test
    void compute_central_element_sum() throws IOException {
        Map<Integer, Set<Integer>> rulesMap = Files.lines(Path.of("src/test/resources/day5.txt"))
                .filter(line -> line.contains("|"))
                .map(line -> line.split("\\|"))
                .map(List::of)
                .collect(groupingBy(list -> Integer.parseInt(list.getFirst()), mapping(list -> Integer.parseInt(list.get(1)), toSet())));

        List<List<Integer>> modificationLines =
                Files.lines(Path.of("src/test/resources/day5.txt"))
                .filter(line -> !line.contains("|") && !line.isBlank())
                .map(line -> line.split(","))
                .map(List::of)
                .map(list -> list.stream().map(Integer::parseInt).toList())
                .toList();

        Day5 day5 = new Day5();
        System.out.println(day5.sumOfCentralElements(rulesMap, modificationLines));
    }



}