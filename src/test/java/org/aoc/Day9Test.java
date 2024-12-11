package org.aoc;

import org.aoc.day9.Day9;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day9Test {
    @Test
    void test() {
        System.out.println(Day9.parseDiskMap("12345"));
    }

    @Test
    void test2() {
        List<String> diskMap = Day9.parseDiskMap("2333133121414131402");
        System.out.println(diskMap);
        Day9.compactDisk(diskMap);
        System.out.println(diskMap);
    }

    @Test
    void test3() {
        System.out.println(new Day9().compute_checksum());
    }
}
