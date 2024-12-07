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


}
