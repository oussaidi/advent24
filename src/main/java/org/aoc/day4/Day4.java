package org.aoc.day4;

import java.util.List;
import java.util.Set;

public class Day4 {

    public int xmasCount(char[][] matrix){
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'X') {
                    if(checkRight(matrix, i, j)){
                        count++;
                    }
                    if(checkLeft(matrix, i, j)){
                        count++;
                    }
                    if (checkDown(matrix, i, j)) {
                        count++;
                    }
                    if(checkUp(matrix, i, j)){
                        count++;
                    }
                    if(checkDiagonalRightDown(matrix, i, j)) {
                        count++;
                    }
                    if(checkDiagonalRightUp(matrix, i, j)){
                        count++;
                    }
                    if(checkDiagonalLeftDown(matrix, i, j)){
                        count++;
                    }
                    if(checkDiagonalLeftUp(matrix, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countXwrittenWithMAS(char[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'A') {
                    if(Set.of("MAS", "SAM").contains(extractLeftToRightDownDiagonal(matrix, i, j)) &&
                            Set.of("MAS", "SAM").contains(extractLeftToRightUpDiagonal(matrix, i, j))){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static String extractLeftToRightDownDiagonal(char[][] matrix, int i, int j) {
        if(i - 1 >= 0 && j + 1 < matrix[i].length && i + 1 < matrix.length && j - 1 >= 0)
            return "" + matrix[i - 1][j + 1] + matrix[i][j] + matrix[i + 1][j - 1];
        return "XXX";
    }

    private static String extractLeftToRightUpDiagonal(char[][] matrix, int i, int j) {
        if(i - 1 >= 0 && j - 1 >= 0 && i + 1 < matrix.length && j + 1 < matrix[i].length)
            return "" + matrix[i - 1][j - 1] + matrix[i][j] + matrix[i + 1][j + 1];
        return "XXX";
    }

    private boolean checkRight(char[][] matrix, int i, int j) {
        if (j + 3 < matrix[i].length) {
            return matrix[i][j + 1] == 'M' && matrix[i][j + 2] == 'A' && matrix[i][j + 3] == 'S';
        }
        return false;
    }

    private boolean checkLeft(char[][] matrix, int i, int j) {
        if (j - 3 >= 0) {
            return matrix[i][j - 1] == 'M' && matrix[i][j - 2] == 'A' && matrix[i][j - 3] == 'S';
        }
        return false;
    }

    private boolean checkDown(char[][] matrix, int i, int j) {
        if (i + 3 < matrix.length) {
            return matrix[i + 1][j] == 'M' && matrix[i + 2][j] == 'A' && matrix[i + 3][j] == 'S';
        }
        return false;
    }

    private boolean checkUp(char[][] matrix, int i, int j) {
        if (i - 3 >= 0) {
            return matrix[i - 1][j] == 'M' && matrix[i - 2][j] == 'A' && matrix[i - 3][j] == 'S';
        }
        return false;
    }

    private boolean checkDiagonalRightDown(char[][] matrix, int i, int j) {
        if (i + 3 < matrix.length && j + 3 < matrix[i].length) {
            return matrix[i + 1][j + 1] == 'M' && matrix[i + 2][j + 2] == 'A' && matrix[i + 3][j + 3] == 'S';
        }
        return false;
    }

    private boolean checkDiagonalRightUp(char[][] matrix, int i, int j) {
        if (i - 3 >= 0 && j + 3 < matrix[i].length) {
            return matrix[i - 1][j + 1] == 'M' && matrix[i - 2][j + 2] == 'A' && matrix[i - 3][j + 3] == 'S';
        }
        return false;
    }

    private boolean checkDiagonalLeftDown(char[][] matrix, int i, int j) {
        if (i + 3 < matrix.length && j - 3 >= 0) {
            return matrix[i + 1][j - 1] == 'M' && matrix[i + 2][j - 2] == 'A' && matrix[i + 3][j - 3] == 'S';
        }
        return false;
    }

    private boolean checkDiagonalLeftUp(char[][] matrix, int i, int j) {
        if (i - 3 >= 0 && j - 3 >= 0) {
            return matrix[i - 1][j - 1] == 'M' && matrix[i - 2][j - 2] == 'A' && matrix[i - 3][j - 3] == 'S';
        }
        return false;
    }
}
