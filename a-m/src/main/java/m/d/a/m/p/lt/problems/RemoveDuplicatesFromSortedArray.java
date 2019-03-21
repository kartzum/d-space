package m.d.a.m.p.lt.problems;

public class RemoveDuplicatesFromSortedArray {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 1, -2, 0, 0, 0}));
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 2}));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null) {
                return -1;
            }
            if (nums.length <= 1) {
                return 1;
            }
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
