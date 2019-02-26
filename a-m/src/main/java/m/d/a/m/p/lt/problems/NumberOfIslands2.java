package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class NumberOfIslands2 {
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
            int result = 0;
            final Stack<Integer> stack = new Stack<>();
            final int h = grid.length;
            for (int j = 0; j < h; j++) {
                final int w = grid[j].length;
                for (int i = 0; i < w; i++) {
                    final char c = grid[j][i];
                    if (c == '1') {
                        result += 1;
                        final int k = j * w + i;
                        stack.push(k);
                        while (!stack.isEmpty()) {
                            final int n = stack.pop();
                            final int y = n / w;
                            final int x = n % w;
                            if (x >= 0 && y >= 0 && x < w && y < h && grid[y][x] == '1') {
                                grid[y][x] = '0';
                                stack.push((y - 1) * w + x);
                                stack.push((y + 1) * w + x);
                                stack.push(y * w + (x - 1));
                                stack.push(y * w + (x + 1));
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}
