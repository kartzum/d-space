package m.d.a.m.p.lt.problems;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FloodFill {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final int[][] i1 = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };
        final int[][] r1 = new Solution().floodFill(i1, 1, 1, 2);
        print(r1);

        final int[][] i2 = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
        };
        final int[][] r2 = new Solution().floodFill(i2, 0, 1, 2);
        print(r2);
    }

    private static void print(int[][] image) {
        for (int j = 0; j < image.length; j++) {
            for (int i = 0; i < image[j].length; i++) {
                System.out.print(image[j][i]);
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            dfs(image, sr, sc, newColor, image[sr][sc]);
            return image;
        }

        public void dfs(int[][] image, int sr, int sc, int newColor, int color) {
            if (sr < 0 || sr > image.length - 1 || sc < 0 || sc > image[0].length - 1 || image[sr][sc] != color || image[sr][sc] == newColor)
                return;
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, color);
            dfs(image, sr + 1, sc, newColor, color);
            dfs(image, sr, sc - 1, newColor, color);
            dfs(image, sr, sc + 1, newColor, color);
        }
    }

    static class Solution3 {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            final int color = image[sr][sc];
            dfs(image, sr, sc, newColor, color);
            return image;
        }

        private void dfs(int[][] image, int sr, int sc, int newColor, int color) {
            if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == color) {
                image[sr][sc] = newColor;
                dfs(image, sr + 1, sc, newColor, color);
                dfs(image, sr - 1, sc, newColor, color);
                dfs(image, sr, sc + 1, newColor, color);
                dfs(image, sr, sc - 1, newColor, color);
            }
        }
    }

    static class Solution2 {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            final Stack<Point> stack = new Stack<>();
            stack.push(new Point(sc, sr));
            final int color = image[sc][sr];
            final List<Point> visited = new ArrayList<>();
            while (!stack.isEmpty()) {
                final Point p = stack.pop();
                if (!visited.contains(p)) {
                    visited.add(p);
                    if (
                            p.y >= 0 && p.y < image.length &&
                                    p.x >= 0 && p.x < image[p.y].length &&
                                    image[p.y][p.x] == color
                    ) {
                        image[p.y][p.x] = newColor;
                        if (p.x - 1 >= 0 && image[p.y][p.x - 1] == color) {
                            stack.push(new Point(p.x - 1, p.y));
                        }
                        if (p.x + 1 < image[p.y].length && image[p.y][p.x + 1] == color) {
                            stack.push(new Point(p.x + 1, p.y));
                        }
                        if (p.y - 1 >= 0 && image[p.y - 1][p.x] == color) {
                            stack.push(new Point(p.x, p.y - 1));
                        }
                        if (p.y + 1 < image.length && image[p.y + 1][p.x] == color) {
                            stack.push(new Point(p.x, p.y + 1));
                        }
                    }
                }
            }
            return image;
        }
    }
}
