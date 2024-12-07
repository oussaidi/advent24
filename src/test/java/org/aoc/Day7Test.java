package org.aoc;

import org.aoc.day7.Day7;
import org.aoc.day7.InputLine;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Day7Test {

    @Test
    void count_plausible_test_values() {
        List<InputLine> inputList = FileReader.readFile("src/test/resources/day7.txt")
                .stream()
                .map(line -> line.split(" "))
                .map(line -> {line[0]=line[0].replace(":", ""); return line;})
                .map(line -> new InputLine(new BigInteger((line[0])), Arrays.stream(line).skip(1).map(BigInteger::new).toList()))
                .toList();

        Day7 day7 = new Day7();
        System.out.println(day7.sumPlausibleTestValues(inputList));
    }
}
