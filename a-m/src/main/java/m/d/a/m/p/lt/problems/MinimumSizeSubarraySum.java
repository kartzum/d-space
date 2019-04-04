package m.d.a.m.p.lt.problems;

public class MinimumSizeSubarraySum {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int[] sums = new int[nums.length];
            sums[0] = nums[1];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int sum = sums[j] - sums[i] + nums[i];
                    if (sum >= s) {
                        ans = Math.min(ans, (j - i + 1));
                        break;
                    }
                }
            }
            return (ans != Integer.MAX_VALUE ? ans : 0);
        }
    }
}
