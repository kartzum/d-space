package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final int[] r1 = new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(java.util.Arrays.toString(r1));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            final int[] r = new int[T.length];
            final Stack<Integer> stack = new Stack<>();
            for (int i = T.length - 1; i >= 0; --i) {
                while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
                r[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return r;
        }
    }
}
