package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().missingNumber(new int[]{1}));
    }

    static class Solution {
        public int missingNumber(int[] nums) {
            Set<Integer> numSet = new HashSet<Integer>();
            for (int num : nums) numSet.add(num);

            int expectedNumCount = nums.length + 1;
            for (int number = 0; number < expectedNumCount; number++) {
                if (!numSet.contains(number)) {
                    return number;
                }
            }
            return -1;
        }
    }
}
