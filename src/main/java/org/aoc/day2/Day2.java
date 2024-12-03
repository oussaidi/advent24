package org.aoc.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

public class Day2 {

    private static final Set<Integer> ALLOWED_DELTAS = Set.of(1, 2, 3);

    private static final BiPredicate<Integer, Integer> IS_ALLOWED_DELTA = (a, b) -> ALLOWED_DELTAS.contains(Math.abs(a - b));

    public long safeReports(List<List<Integer>> reports) {
        return reports.stream().filter(this::isSafe).count();
    }

    public boolean isSafe(List<Integer> report) {
        for(int i = 0; i < report.size(); i++) {
            if(!(isSortedAsc(report) || isSortedDesc(report) || canBeMadeSafe(report))) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeMadeSafe(List<Integer> report) {
        List<Integer> transformedReport;
        for(int i = 0; i < report.size(); i++) {
            transformedReport = new ArrayList<>(report);
            transformedReport.remove(i);
            if(isSortedAsc(transformedReport) || isSortedDesc(transformedReport)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSortedAsc(List<Integer> report) {
        for(int i = 0; i < report.size() - 1; i++) {
            if (report.get(i) > report.get(i + 1) || IS_ALLOWED_DELTA.negate().test(report.get(i), report.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedDesc(List<Integer> report) {
        for(int i = 0; i < report.size() - 1; i++) {
            if (report.get(i) < report.get(i + 1) || IS_ALLOWED_DELTA.negate().test(report.get(i), report.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
