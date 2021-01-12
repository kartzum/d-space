package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] r = new Solution().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
        System.out.println(Arrays.toString(r));
    }

    static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] counts = new int[101];
            int[] countUntil = new int[101];
            for (int num : nums) {
                counts[num]++;
                countUntil[num]++;
            }

            for (int i = 1; i < counts.length; i++) {
                countUntil[i] += countUntil[i - 1];
            }

            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = countUntil[nums[i]] - counts[nums[i]];
            }
            return res;
        }
    }
}
