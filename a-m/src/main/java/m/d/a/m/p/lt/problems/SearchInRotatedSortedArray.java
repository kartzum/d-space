package m.d.a.m.p.lt.problems;

public class SearchInRotatedSortedArray {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        int[] nums = new int[]{4, 5, 1, 2, 3};
        /*int i = new Solution().searchIndex(nums, 0, nums.length - 1);
        System.out.println(i);
        System.out.println(new Solution().binary(new int[]{1, 2, 3, 4, 5}, 0, 4, 5));*/
        System.out.println(new Solution().search(nums, 4));
    }

    static class Solution {
        public int searchIndex(int[] nums, int left, int right) {
            if (nums[left] < nums[right]) {
                return 0;
            }
            while (left <= right) {
                int pivot = (left + right) / 2;
                if (nums[pivot] > nums[pivot + 1]) {
                    return pivot + 1;
                } else {
                    if (nums[pivot] < nums[left]) {
                        right = pivot - 1;
                    } else {
                        left = pivot + 1;
                    }
                }
            }
            return 0;
        }

        public int binary(int[] nums, int left, int right, int target) {
            while (left <= right) {
                int i = (right + left) / 2;
                if (nums[i] == target) {
                    return i;
                }
                if (nums[i] < target) {
                    left = i + 1;
                } else {
                    right = i - 1;
                }
            }
            return -1;
        }

        public int search(int[] nums, int target) {
            int n = nums.length;

            if (n == 0)
                return -1;
            if (n == 1)
                return nums[0] == target ? 0 : -1;

            int i = searchIndex(nums, 0, n - 1);

            if (nums[i] == target) {
                return i;
            }

            if (i == 0) {
                return binary(nums, 0, n - 1, target);
            }

            if (target < nums[0]) {
                return binary(nums, i, n - 1, target);
            }

            return binary(nums, 0, i, target);
        }
    }
}
