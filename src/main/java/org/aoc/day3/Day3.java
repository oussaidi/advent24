package org.aoc.day3;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    private static final String DO_MULTIPLY = "ENABLED";
    private static final String DONT_MULTIPLY = "DISABLED";

    public int computeMatchedMultiplications(String inputString){
        String newInput = inputString.replace("do()", "ENABLED");
        newInput = newInput.replace("don't()", "DISABLED");
        Pattern pattern = Pattern.compile("DISABLED|ENABLED|mul\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(newInput);
        boolean multiply = true;
        int result = 0;
        for(MatchResult matchResult : matcher.results().toList()){
            if(matchResult.group(0).equals(DO_MULTIPLY)){
                multiply = true;
            } else if(matchResult.group(0).equals(DONT_MULTIPLY)){
                multiply = false;
            } else if(multiply){
                int firstNumber = Integer.parseInt(matchResult.group(1));
                int secondNumber = Integer.parseInt(matchResult.group(2));
                result += firstNumber * secondNumber;
            }
        }
        return result;
    }
}
