package m.d.a.m.p.lt.problems;

public class NumberOfIslands {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        System.out.println(new Solution().numIslands(grid1));
        final char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(new Solution().numIslands(grid2));
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int count = 0;
            for (int j = 0; j < grid.length; j++) {
                for (int i = 0; i < grid[j].length; i++) {
                    final char c = grid[j][i];
                    System.out.print(c);
                    if (c == '1') {
                        fillIsland(grid, j, i);
                        count++;
                    }
                }
                System.out.println();
            }
            return count;
        }

        void fillIsland(char[][] grid, int j, int i) {
            if (j < 0 || i < 0 || j > grid.length - 1 || i > grid[j].length - 1 || grid[j][i] != '1') return;
            grid[j][i] = '0';
            fillIsland(grid, j + 1, i);
            fillIsland(grid, j - 1, i);
            fillIsland(grid, j, i + 1);
            fillIsland(grid, j, i - 1);
        }
    }
}
