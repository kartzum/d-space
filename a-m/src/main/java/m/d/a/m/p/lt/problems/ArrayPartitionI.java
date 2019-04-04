package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class ArrayPartitionI {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().arrayPairSum(new int[]{1, 4, 3, 2}));
    }

    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                System.out.println(sum + ", " + nums[i] + ", " + (sum + nums[i]));
                sum += nums[i];
            }
            return sum;
        }
    }
}
