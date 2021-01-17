package m.d.a.m.p.lt.problems;

public class MaximumProductSubarray {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().maxProduct(new int[] {2,3,-2,4}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0) return 0;

            int max_so_far = nums[0];
            int min_so_far = nums[0];
            int result = max_so_far;

            for (int i = 1; i < nums.length; i++) {
                int curr = nums[i];
                int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
                min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

                max_so_far = temp_max;

                result = Math.max(max_so_far, result);
            }

            return result;
        }
    }
}
