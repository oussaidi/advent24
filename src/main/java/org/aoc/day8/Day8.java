package org.aoc.day8;

import org.aoc.day6.Position;

import java.util.*;
import java.util.stream.Collectors;

public class Day8 {
    public int antiNodes(List<String> inputLines) {
        Map<Character, List<Position>> antennasByType = findAntennas(inputLines);
        int lines = inputLines.size();
        int columns = inputLines.getFirst().length();
        return antennasByType.values().stream()
                .map(this::findAntinodesByCategory)
                .flatMap(Set::stream)
                .filter(position -> position.x() >= 0 && position.x() < lines && position.y() >= 0 && position.y() < columns)
                .collect(Collectors.toSet())
                .size();
    }

    private Map<Character, List<Position>> findAntennas(List<String> inputLines) {
        Map<Character, List<Position>> antennasByType = new HashMap<>();
        for (int i = 0; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            for (int j = 0; j < line.length(); j++) {
                char antennaType = line.charAt(j);
                if (antennaType != '.') {
                    Position position = new Position(i, j);
                    antennasByType.computeIfAbsent(antennaType, k -> new ArrayList<>()).add(position);
                }
            }
        }
        return antennasByType;
    }

    Set<Position> findAntinodesByCategory(List<Position> antennas) {
        Set<Position> antinodes = new HashSet<>();
        for (int i = 0; i < antennas.size(); i++) {
            Position antenna = antennas.get(i);
            for (int j = i + 1; j < antennas.size(); j++) {
                Position otherAntenna = antennas.get(j);
                antinodes.add(findSymmetricPosition(antenna, otherAntenna));
                antinodes.add(findSymmetricPosition(otherAntenna, antenna));
            }
        }
        return antinodes;
    }

    private Position findSymmetricPosition(Position antenna, Position otherAntenna) {
        int x = 2 * otherAntenna.x() - antenna.x();
        int y = 2 * otherAntenna.y() - antenna.y();
        return new Position(x, y);
    }
}
