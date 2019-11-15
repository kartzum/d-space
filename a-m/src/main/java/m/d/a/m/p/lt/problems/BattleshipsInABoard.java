package m.d.a.m.p.lt.problems;

public class BattleshipsInABoard {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        char[][] board = new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        System.out.println(new Solution().countBattleships(board));
    }

    static class Solution {
        public int countBattleships(char[][] board) {
            int ships = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'X') {
                        if (i > 0 && board[i - 1][j] == 'X')
                            continue;
                        else if (j > 0 && board[i][j - 1] == 'X')
                            continue;
                        else
                            ships++;
                    }
                }
            }
            return ships;
        }
    }
}
