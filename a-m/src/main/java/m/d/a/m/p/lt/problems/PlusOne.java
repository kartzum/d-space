package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class PlusOne {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 9, 9})));
    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] += carry;
                if (digits[i] <= 9) // early return
                    return digits;
                digits[i] = 0;
            }
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
    }
}
