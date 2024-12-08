package org.aoc;

import org.aoc.day8.Day8;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day8Test {

    @Test
    void count_total_antinodes() {
        List<String> inputLines = FileReader.readFile("src/test/resources/day8.txt");
        int antinodes = new Day8().antiNodes(inputLines);
        System.out.println(antinodes);
    }
}
