package m.d.a.m.p.lt.problems;

public class TargetSum {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final int[] v1 = new int[]{1, 1, 1, 1, 1};
        final int r1 = new Solution().findTargetSumWays(v1, 3);
        System.out.println(r1);
    }

    static class Solution {
        int result = 0;

        public int findTargetSumWays(int[] nums, int S) {
            result = 0;
            calc(nums, 0, 0, S);
            return result;
        }

        void calc(int[] nums, int i, int sum, int S) {
            if (i == nums.length) {
                if (sum == S) {
                    result += 1;
                }
            } else {
                calc(nums, i + 1, sum + nums[i], S);
                calc(nums, i + 1, sum - nums[i], S);
            }
        }
    }
}
