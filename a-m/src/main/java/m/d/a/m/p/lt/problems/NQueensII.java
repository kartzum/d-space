package m.d.a.m.p.lt.problems;

public class NQueensII {
    public static void main(final String[] args) {
        test();
    }

    private static void test() {
        System.out.println(new Solution().totalNQueens(4));
    }

    public static class Solution {
        public int totalNQueens(int n) {
            int[][] board = new int[n][n];
            return nQueens(0, 0, board);
        }

        public int nQueens(int i, int j, int[][] board) {
            int solutions = 0;
            for (int jj = j; jj < board[i].length; jj++) {
                if (!checkMove(i, jj, board)) continue; // checks if is possible to place a Queen in i,j
                if (i == board.length - 1) return 1; // if we can place a Queen at last row, this is a solution
                board[i][jj] = 1; // try to place a Queen in i,j
                if (i + 1 < board.length)
                    solutions += nQueens(i + 1, 0, board); // go to next row, we can place just 1 Queen per row
                board[i][jj] = 0; // Backtracking
            }
            return solutions;
        }

        public boolean checkMove(int i, int j, int[][] board) {
            // checkMove needs to check just in previous rows for Queens
            for (int ii = 0; ii < i; ii++) {
                if (board[ii][j] == 1) return false; // Checks for queens already placed in this col
            }
            int row;
            int col;
            row = i - 1;
            col = j - 1;
            while (row >= 0 && col >= 0) {
                if (board[row--][col--] == 1)
                    return false; // Checks for queens already placed in top-left -> bottom-right diagonal
            }
            row = i - 1;
            col = j + 1;
            while (row >= 0 && col < board[row].length) {
                if (board[row--][col++] == 1)
                    return false; // Checks for queens already placed in top-right -> bottom-left diagonal
            }
            return true;
        }
    }

    private static void test2() {
        System.out.println(new Solution2().totalNQueens(4));
    }

    public static class Solution2 {
        private int n;

        public int totalNQueens(int n) {
            this.n = n;

            int[][] board = new int[n][n];
            boolean result = solveNQUtil(board, 0);
            printSolution(board);

            return 0;
        }

        boolean solveNQUtil(int board[][], int col) {
            /* base case: If all queens are placed
           then return true */
            if (col >= this.n)
                return true;

        /* Consider this column and try placing
           this queen in all rows one by one */
            for (int i = 0; i < this.n; i++) {
            /* Check if the queen can be placed on
               board[i][col] */
                if (isSafe(board, i, col)) {
                    /* Place this queen in board[i][col] */
                    board[i][col] = 1;

                    /* recur to place rest of the queens */
                    if (solveNQUtil(board, col + 1) == true)
                        return true;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                    board[i][col] = 0; // BACKTRACK
                }
            }

        /* If the queen can not be placed in any row in
           this colum col, then return false */
            return false;
        }

        boolean isSafe(int board[][], int row, int col) {
            int i, j;

            /* Check this row on left side */
            for (i = 0; i < col; i++)
                if (board[row][i] == 1)
                    return false;

            /* Check upper diagonal on left side */
            for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 1)
                    return false;

            /* Check lower diagonal on left side */
            for (i = row, j = col; j >= 0 && i < this.n; i++, j--)
                if (board[i][j] == 1)
                    return false;

            return true;
        }

        void printSolution(int board[][]) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++)
                    System.out.print(" " + board[i][j]
                            + " ");
                System.out.println();
            }
        }
    }
}
