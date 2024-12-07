package org.aoc.day7;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day7 {

    public BigInteger sumPlausibleTestValues(List<InputLine> inputList) {
        return inputList.stream()
                .filter(this::isPlausible)
                .map(InputLine::computaionResult)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private boolean isPlausible(InputLine inputLine) {
        List<BigInteger> inputValues = inputLine.inputValues();

        Set<BigInteger> lastComputationLine = new HashSet<>();
        lastComputationLine.add(inputValues.getFirst());

        for(int i = 1; i < inputValues.size(); i++){
            Set<BigInteger> newComputationLine = new HashSet<>();
            BigInteger inputValue = inputValues.get(i);
            for(BigInteger element : lastComputationLine){
                BigInteger additionResult = element.add(inputValue);
                BigInteger multiplicationResult = element.multiply(inputValue);
                BigInteger concatenationResult = new BigInteger(element + inputValue.toString());
                if(additionResult.compareTo(inputLine.computaionResult()) <= 0){
                    newComputationLine.add(additionResult);
                }
                if(multiplicationResult.compareTo(inputLine.computaionResult()) <= 0){
                    newComputationLine.add(multiplicationResult);
                }
                if(concatenationResult.compareTo(inputLine.computaionResult()) <= 0){
                    newComputationLine.add(concatenationResult);
                }
            }
            lastComputationLine = newComputationLine;
        }
        return lastComputationLine.contains(inputLine.computaionResult());
    }
}
