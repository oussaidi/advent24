package org.aoc;

import org.aoc.day3.Day3;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day3Test {

    @Test
    void one_match() {
        Day3 day3 = new Day3();
        assertThat(day3.computeMatchedMultiplications("qqsdhbjmul(3,4)sdcksj")).isEqualTo(12);
    }

    @Test
    void multiple_matches() {
        Day3 day3 = new Day3();
        assertThat(day3.computeMatchedMultiplications("qqsdhbjmul(3,4)sdcksjmul(12,3)")).isEqualTo(48);
    }

    @Test
    void only_one_multiplication() {
        Day3 day3 = new Day3();
        assertThat(day3.computeMatchedMultiplications("don't()qqsdhbjmul(3,4)sdcksjmul(12,3)do()mul(1,1)")).isEqualTo(1);
    }

    @Test
    void enable_disable_enable() {
        Day3 day3 = new Day3();
        assertThat(day3.computeMatchedMultiplications("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")).isEqualTo(48);
    }

    @Test
    void test_compute_matched_multiplications_from_file() throws IOException {
        String inputString = readFile();
        Day3 day3 = new Day3();
        System.out.println(day3.computeMatchedMultiplications(inputString));
    }

    private String readFile() throws IOException {
        return Files.readString(Path.of("src/test/resources/day3.txt"));
    }
}
