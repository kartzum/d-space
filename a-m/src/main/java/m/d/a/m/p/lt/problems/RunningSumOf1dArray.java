package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class RunningSumOf1dArray {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution().runningSum(nums)));
    }

    static class Solution {
        public int[] runningSum(int[] nums) {
            int s = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[i] += s;
                s = nums[i];
            }
            return nums;
        }
    }
}
