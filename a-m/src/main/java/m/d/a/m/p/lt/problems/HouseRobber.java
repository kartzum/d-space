package m.d.a.m.p.lt.problems;

public class HouseRobber {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.print(new Solution().rob(nums));
    }

    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;

            int ppVal = 0;
            int pVal = 0;
            int ans = 0;

            for (int i = 0; i < n; i++) {

                nums[i] = nums[i] + ppVal;
                ans = Math.max(ans, nums[i]);

                ppVal = pVal;
                pVal = ans;
            }

            return ans;
        }
    }
}
