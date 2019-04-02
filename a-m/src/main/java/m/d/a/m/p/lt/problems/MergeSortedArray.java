package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(final String[] args) {
        test2();
    }

    static void test1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    static void test2() {
        int[] nums1 = new int[]{1, 2, 3, 4, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 4, 7, 8, 9};
        new Solution().merge(nums1, 4, nums2, 5);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int k = m + n - 1;
            while (m - 1 >= 0 && n - 1 >= 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[k] = nums1[m - 1];
                    m--;
                } else {
                    nums1[k] = nums2[n - 1];
                    n--;
                }
                k--;
            }
            while (m - 1 >= 0) {
                nums1[k] = nums1[m - 1];
                k--;
                m--;
            }
            while (n - 1 >= 0) {
                nums1[k] = nums2[n - 1];
                k--;
                n--;
            }
        }
    }
}
