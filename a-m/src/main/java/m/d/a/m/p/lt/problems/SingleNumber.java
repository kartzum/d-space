package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                } else {
                    set.remove(nums[i]);
                }
            }
            return set.size() > 0 ? set.iterator().next() : -1;
        }
    }
}
