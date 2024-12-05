package org.aoc;

import org.aoc.day4.Day4;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    @Test
    void zero_when_no_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'X', 'M', 'A'},
                {'Y', 'S', 'X'},
                {'X', 'S', 'M'}
        };
        assertEquals(0, day4.xmasCount(matrix));
    }

    @Test
    void one_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'X', 'M', 'A', 'S'}
        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void inverted_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'S', 'A', 'M', 'X'}
        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void vertical_down_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'X', 'M', 'A'},
                {'S', 'X', 'S'},
                {'M', 'M', 'M'},
                {'S', 'A', 'S'},
                {'X', 'S', 'A'}


        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void vertical_up_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'X', 'M', 'A'},
                {'S', 'X', 'S'},
                {'A', 'M', 'M'},
                {'M', 'M', 'S'},
                {'X', 'S', 'A'}
        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void diagonal_right_down_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'X', 'M', 'A', 'N'},
                {'X', 'M', 'A', 'J'},
                {'X', 'M', 'A', 'R'},
                {'X', 'M', 'N', 'S'}
        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void diagonal_right_up_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'X', 'M', 'H', 'S'},
                {'X', 'M', 'A', 'J'},
                {'X', 'M', 'A', 'R'},
                {'X', 'M', 'N', 'T'}
        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void diagonal_left_down_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'X', 'M', 'H', 'X'},
                {'X', 'M', 'M', 'J'},
                {'X', 'A', 'A', 'R'},
                {'S', 'M', 'N', 'T'}
        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void diagonal_left_up_xmas_found() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'S', 'M', 'H', 'X'},
                {'X', 'A', 'M', 'J'},
                {'X', 'A', 'M', 'R'},
                {'T', 'M', 'N', 'X'}
        };
        assertThat(day4.xmasCount(matrix)).isOne();
    }

    @Test
    void multiple_xmas_found() {
        Day4 day4 = new Day4();
        String[] stringMatrix = new String[]{
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        };
        char[][] matrix = Arrays.stream(stringMatrix).map(String::toCharArray).toArray(char[][]::new);
        assertThat(day4.xmasCount(matrix)).isEqualTo(18);
    }

    private char[][] readInputFromFile(String[] stringMatrix) throws IOException {
        return Files.lines(Path.of("src/test/resources/day4.txt")).map(String::toCharArray).toArray(char[][]::new);
    }

    @Test
    void compute_xmas_count() throws IOException {
        Day4 day4 = new Day4();
        char[][] matrix = readInputFromFile(new String[]{});
        System.out.println(day4.xmasCount(matrix));
    }

    @Test
    void compute_count_x_written_with_mas() {
        Day4 day4 = new Day4();
        char[][] matrix = new char[][]{
                {'M', 'A', 'S'},
                {'A', 'A', 'A'},
                {'M', 'A', 'S'}
        };
        assertThat(day4.countXwrittenWithMAS(matrix)).isEqualTo(1);
    }

    @Test
    void compute_count_x_written_with_mas_from_file() throws IOException {
        Day4 day4 = new Day4();
        char[][] matrix = readInputFromFile(new String[]{});
        System.out.println(day4.countXwrittenWithMAS(matrix));
    }
}