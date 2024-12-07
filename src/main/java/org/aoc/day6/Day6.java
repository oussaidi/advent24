package org.aoc.day6;

import java.util.*;

public class Day6 {

    private static final String GUARD = "^";
    public int computeTotalVisitedCells(List<String> strings) {
        Set<Position> visitedCells = new HashSet<>();
        Direction currentDirection = Direction.UP;
        Position currentPosition = findGuardInitialPosition(new ArrayList<>(strings));
        visitedCells.add(currentPosition);

        while (true) {
            Position nextPosition = currentPosition.move(currentDirection);
            if(nextPosition.x() < 0 || nextPosition.x() >= strings.size()
                    || nextPosition.y() < 0 || nextPosition.y() >= strings.getFirst().length()) {
                return visitedCells.size();
            }
            if (isObstacle(strings, nextPosition)) {
                currentDirection = currentDirection.turnRight();
            } else {
                currentPosition = nextPosition;
                visitedCells.add(currentPosition);
            }
        }
    }

    private boolean isObstacle(List<String> strings, Position nextPosition) {
        return strings.get(nextPosition.x()).charAt(nextPosition.y()) == '#';
    }

    private Position findGuardInitialPosition(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            if(strings.get(i).contains(GUARD)) {
                return new Position(i, strings.get(i).indexOf(GUARD));
            }
        }
        throw new RuntimeException("Guard not found");
    }

    public int countLoopInducingObstaclePositions(List<String> strings) {
        int count = 0;
        for (int i = 0; i < strings.size(); i++) {
            List<String> stringsCopy = new ArrayList<>(strings);
            for (int j = 0; j < strings.get(i).length(); j++) {
                if(strings.get(i).charAt(j) != '#' && strings.get(i).charAt(j) != GUARD.charAt(0)) {
                    stringsCopy.set(i, strings.get(i).substring(0, j) + '#' + strings.get(i).substring(j+1));
                    if(matrixHasALoop(stringsCopy)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    private boolean matrixHasALoop(List<String> strings) {
        Set<Position> visitedCells = new HashSet<>();
        int loopDetector = 0;
        Direction currentDirection = Direction.UP;
        Position currentPosition = findGuardInitialPosition(new ArrayList<>(strings));
        visitedCells.add(currentPosition);

        while (true) {
            Position nextPosition = currentPosition.move(currentDirection);
            if(nextPosition.x() < 0 || nextPosition.x() >= strings.size()
                    || nextPosition.y() < 0 || nextPosition.y() >= strings.getFirst().length()) {
                return false;
            }
            if (isObstacle(strings, nextPosition)) {
                currentDirection = currentDirection.turnRight();
            } else {
                currentPosition = nextPosition;
                if(visitedCells.contains(currentPosition)) {
                    loopDetector++;
                    if(loopDetector == visitedCells.size()) {
                        return true;
                    }
                }else {
                    loopDetector = 0;
                }
                visitedCells.add(currentPosition);
            }
        }
    }
}
