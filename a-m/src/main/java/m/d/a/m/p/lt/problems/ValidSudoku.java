package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(final String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(new Solution().isValidSudoku(board));
    }

    private static void test2() {
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(new Solution().isValidSudoku(board));
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set<Character> s = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char c = board[i][j];
                    if (s.contains(c)) {
                        return false;
                    }
                    if (c != '.') {
                        s.add(c);
                    }
                }
                s.clear();
            }
            s.clear();
            for (int j = 0; j < board[0].length; j++) {
                for (int i = 0; i < board.length; i++) {
                    char c = board[i][j];
                    if (s.contains(c)) {
                        return false;
                    }
                    if (c != '.') {
                        s.add(c);
                    }
                }
                s.clear();
            }
            s.clear();
            for (int i = 0; i < board.length / 3; i++) {
                for (int j = 0; j < board[i].length / 3; j++) {
                    s.clear();
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            char c = board[i * 3 + k][j * 3 + l];
                            if (s.contains(c)) {
                                return false;
                            }
                            if (c != '.') {
                                s.add(c);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
