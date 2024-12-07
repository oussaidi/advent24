package org.aoc;

import org.aoc.day6.Day6;
import org.junit.jupiter.api.Test;

import static org.aoc.FileReader.readFile;

public class Day6Test {
    @Test
    void count_visited_cells() {
        Day6 day6 = new Day6();
        System.out.println(day6.computeTotalVisitedCells(readFile("src/test/resources/day6.txt")));
    }

    @Test
    void count_loop_inducing_obstacle_positions() {
        Day6 day6 = new Day6();
        System.out.println(day6.countLoopInducingObstaclePositions(readFile("src/test/resources/day6.txt")));
    }
}
