package org.aoc.day6;

public record Position (int x, int y) {
    public Position move(Direction direction) {
        return switch (direction) {
            case UP -> new Position(x-1, y);
            case DOWN -> new Position(x+1, y);
            case LEFT -> new Position(x, y-1);
            case RIGHT -> new Position(x, y+1);
        };
    }
}
