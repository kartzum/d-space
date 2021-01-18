package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static void main(final String[] args) {
        test();
    }

    private static void test() {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    static class Solution {
        public int sumSubarrayMins(int[] A) {
            int MOD = 1_000_000_007;
            Stack<RepInteger> stack = new Stack<>();
            int ans = 0, dot = 0;
            for (int j = 0; j < A.length; ++j) {
                int count = 1;
                while (!stack.isEmpty() && stack.peek().val >= A[j]) {
                    RepInteger node = stack.pop();
                    count += node.count;
                    dot -= node.val * node.count;
                }
                stack.push(new RepInteger(A[j], count));
                dot += A[j] * count;
                ans += dot;
                ans %= MOD;
            }
            return ans;
        }
    }

    static class RepInteger {
        int val, count;

        RepInteger(int v, int c) {
            val = v;
            count = c;
        }
    }
}
