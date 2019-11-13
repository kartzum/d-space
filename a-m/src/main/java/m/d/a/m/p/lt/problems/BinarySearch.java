package m.d.a.m.p.lt.problems;

public class BinarySearch {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(new Solution().search(nums, 9));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int h = nums.length - 1;
            while (l <= h) {
                int i = l + (h - l) / 2;
                int v = nums[i];
                if (v == target) {
                    return i;
                } else if (v > target) {
                    h = i - 1;
                } else {
                    l = i + 1;
                }
            }
            return -1;
        }
    }
}
