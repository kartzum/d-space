package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] r = new Solution().productExceptSelf(nums);
        System.out.println(Arrays.toString(r));
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] l = new int[length];
            int[] r = new int[length];
            int[] result = new int[length];
            l[0] = 1;
            for (int i = 1; i < length; i++) {
                l[i] = nums[i - 1] * l[i - 1];
            }
            r[length - 1] = 1;
            for (int i = length - 2; i >= 0; i--) {
                r[i] = nums[i + 1] * r[i + 1];
            }
            for (int i = 0; i < length; i++) {
                result[i] = l[i] * r[i];
            }
            return result;
        }
    }
}
