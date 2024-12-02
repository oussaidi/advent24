package org.aoc;

import org.aoc.day1.Day1;
import org.aoc.day1.Day1Input;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {


    private Day1Input readFile() throws IOException {
        List<Integer> column1 = new LinkedList<>();
        List<Integer> column2 = new LinkedList<>();
        Files.lines(Path.of("src/test/resources/day1.txt")).map(line -> line.split(" {3}"))
                .forEach(line -> {
                    column1.add(Integer.parseInt(line[0]));
                    column2.add(Integer.parseInt(line[1]));
                });

        return new Day1Input(column1, column2);
    }

    @Test
    void when_empty_inputs_return_zero() {
        Day1 day1 = new Day1();
        assertThat(day1.distance(emptyList(), emptyList())).isEqualTo(0);
    }

    @Test
    void one_element_list() {
        Day1 day1 = new Day1();
        assertThat(day1.distance(singleton(3), singleton(1))).isEqualTo(2);
    }

    @Test
    void two_elements_list() {
        Day1 day1 = new Day1();
        assertThat(day1.distance(List.of(3, 4), List.of(1, 3))).isEqualTo(3);
    }

    @Test
    void unsorted_elements_list() {
        Day1 day1 = new Day1();
        assertThat(day1.distance(List.of(1, 4), List.of(3, 1))).isEqualTo(1);
    }

    @Test
    void compute_file_distance() throws IOException {
        Day1Input day1Input = readFile();
        Day1 day1 = new Day1();
        System.out.println(day1.distance(day1Input.firstColumn(), day1Input.secondColumn()));
    }

    @Test
    void compute_similarity() throws IOException {
        Day1Input day1Input = readFile();
        Day1 day1 = new Day1();
        System.out.println(day1.similarity(day1Input.firstColumn(), day1Input.secondColumn()));
    }
}