package m.d.a.m.p.lt.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            if (n1 < n2) {
                return intersect(nums2, nums1);
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums2) {
                if (map.containsKey(num)) {
                    int count = map.get(num);
                    map.put(num, ++count);
                } else {
                    map.put(num, 1);
                }
            }

            int[] intersection = new int[n2];
            int idx = 0;

            for (int num : nums1) {
                if (map.containsKey(num)) {
                    intersection[idx] = num;
                    idx++;
                    if (map.get(num) == 1) {
                        map.remove(num);
                    } else {
                        int count = map.get(num);
                        map.put(num, --count);
                    }
                }
            }

            return Arrays.copyOfRange(intersection, 0, idx);
        }
    }
}
