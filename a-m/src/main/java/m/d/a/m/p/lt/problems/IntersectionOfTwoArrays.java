package m.d.a.m.p.lt.problems;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[]{};
            }
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            List<Integer> r = new ArrayList<>();
            for (int i1 : nums1) {
                s1.add(i1);
            }
            for (int i2 : nums2) {
                s2.add(i2);
            }
            for (int j : s1) {
                if (s2.contains(j)) {
                    r.add(j);
                }
            }
            return r.stream().mapToInt(i -> i).toArray();
        }
    }
}
