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
                .map(antennas -> this.findAntinodesByCategory(antennas, lines, columns))
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

    Set<Position> findAntinodesByCategory(List<Position> antennas, int lines, int columns) {
        Set<Position> antinodes = new HashSet<>();
        for (int i = 0; i < antennas.size(); i++) {
            Position antenna = antennas.get(i);
            for (int j = i + 1; j < antennas.size(); j++) {
                Position otherAntenna = antennas.get(j);
                antinodes.addAll(findAntennasAntinodes(antenna, otherAntenna, lines, columns));
                antinodes.addAll(findAntennasAntinodes(otherAntenna, antenna, lines, columns));
            }
        }
        return antinodes;
    }

    public Set<Position> findAntennasAntinodes(Position referenceAntenna, Position otherAntenna, int lines, int columns) {
        int distanceFactor = 1;
        Set<Position> antinodes = new HashSet<>();
        while(true){
            int x = referenceAntenna.x() + (distanceFactor * (otherAntenna.x() - referenceAntenna.x()));
            int y = referenceAntenna.y() + (distanceFactor * (otherAntenna.y() - referenceAntenna.y()));
            if(x < 0 || x >= lines || y < 0 || y >= columns){
                break;
            }
            else {
                antinodes.add(new Position(x, y));
                distanceFactor++;
            }
        }
        return antinodes;
    }
}
