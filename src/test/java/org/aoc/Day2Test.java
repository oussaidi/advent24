package org.aoc;

import org.aoc.day2.Day2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day2Test {

    private List<List<Integer>> readFile() throws IOException {
       return Files.lines(Path.of("src/test/resources/day2.txt")).map(line -> line.split(" "))
                .map(line -> Arrays.stream(line).map(Integer::parseInt).toList())
                .toList();
    }

    @ParameterizedTest
    @MethodSource
    void test_reports_safety(List<Integer> report, boolean expected) {
        Day2 day2 = new Day2();
        assertThat(day2.isSafe(report)).isEqualTo(expected);
    }

    private static Stream<Arguments> test_reports_safety() {
        return Stream.of(Arguments.of(List.of(7, 6, 4, 2, 1), true),
                Arguments.of(List.of(1, 2, 7, 8, 9), false));
    }

    @Test
    void test_safe_reports_count() throws IOException {
        Day2 day2 = new Day2();
        System.out.println(day2.safeReports(readFile()));
    }
}
