package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class RotateArray {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        int[] r1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(r1, 3);
        System.out.println(Arrays.toString(r1));
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            int t;
            int p;
            for (int i = 0; i < k; i++) {
                p = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    t = nums[j];
                    nums[j] = p;
                    p = t;
                }
            }
        }
    }
}
