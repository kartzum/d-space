package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int l = 0, r = numbers.length - 1;
            while (numbers[l] + numbers[r] != target) {
                if (numbers[l] + numbers[r] > target) r--;
                else l++;
            }
            return new int[]{l + 1, r + 1};
        }
    }
}
