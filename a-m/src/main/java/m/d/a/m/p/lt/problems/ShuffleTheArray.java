package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 3};
        new Solution().shuffle(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int max = 1001;

            for (int i = n; i < nums.length; i++) {
                nums[i] = max * nums[i] + nums[i - n];
            }

            int ind = 0;
            for (int i = n; i < nums.length; i++) {
                nums[ind] = nums[i] % max;
                nums[ind + 1] = nums[i] / max;
                ind += 2;
            }

            return nums;
        }
    }
}
