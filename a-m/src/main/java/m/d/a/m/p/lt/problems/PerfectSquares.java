package m.d.a.m.p.lt.problems;

import java.util.LinkedList;

public class PerfectSquares {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().numSquares(12));
        System.out.println(new Solution().numSquares(13));
    }

    static class Solution {
        public int numSquares(int n) {
            final LinkedList<Integer> queue = new LinkedList<>();
            queue.add(n);
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                final int s = queue.size();
                for (int i = 0; i < s; i++) {
                    final int v = queue.remove();
                    for (int j = 1; j * j <= v; j++) {
                        final int r = v - j * j;
                        if (r == 0) {
                            return level;
                        } else {
                            queue.add(r);
                        }
                    }
                }
            }
            return -1;
        }
    }
}
