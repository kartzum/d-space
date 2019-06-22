package m.d.a.m.p.lt.problems;

public class ClimbingStairs {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution2().climbStairs(3));
    }

    public static class Solution {
        public int climbStairs(int n) {
            int memo[] = new int[n + 1];
            return climb_Stairs(0, n, memo);
        }

        public int climb_Stairs(int i, int n, int memo[]) {
            if (i > n) {
                return 0;
            }
            if (i == n) {
                return 1;
            }
            if (memo[i] > 0) {
                return memo[i];
            }
            memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
            return memo[i];
        }
    }

    public static class Solution2 {
        public int climbStairs(int n) {
            return climb_Stairs(0, n);
        }

        public int climb_Stairs(int i, int n) {
            if (i > n) {
                return 0;
            }
            if (i == n) {
                return 1;
            }
            return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
        }
    }
}
