package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SudokuSolver {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '2', '.', '.', '.', '.'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        new Solution().solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    static class Solution {
        public void solveSudoku(char[][] board) {
            Set<String> set = new HashSet<>();

            // add all existing numbers on board to set
            for (int row = 0; row <= 8; row++) {
                for (int col = 0; col <= 8; col++) {
                    if (board[row][col] != '.') {
                        set.add(board[row][col] + " is found in row " + row);
                        set.add(board[row][col] + " is found in column " + col);
                        set.add(board[row][col] + " is found in sub-box " + row / 3 + "-" + col / 3);
                    }
                }
            }

            helper(board, set);
        }

        private boolean helper(char[][] board, Set<String> set) {
            for (int row = 0; row <= 8; row++) {
                for (int col = 0; col <= 8; col++) {
                    if (board[row][col] == '.') {
                        for (char num = '1'; num <= '9'; num++) {
                            // if num is already in row (or) col (or) in a sub-box, then continue!
                            if (set.contains(num + " is found in row " + row) ||
                                    set.contains(num + " is found in column " + col) ||
                                    set.contains(num + " is found in sub-box " + row / 3 + "-" + col / 3))
                                continue;

                            board[row][col] = num;

                            set.add(board[row][col] + " is found in row " + row);
                            set.add(board[row][col] + " is found in column " + col);
                            set.add(board[row][col] + " is found in sub-box " + row / 3 + "-" + col / 3);

                            if (helper(board, set)) return true;

                            set.remove(board[row][col] + " is found in row " + row);
                            set.remove(board[row][col] + " is found in column " + col);
                            set.remove(board[row][col] + " is found in sub-box " + row / 3 + "-" + col / 3);

                            board[row][col] = '.';
                        }
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
