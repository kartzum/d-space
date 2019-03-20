package m.d.a.m.p.lt.problems;

public class SearchInsertPosition {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        //System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5));
        //System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 2));
        //System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 7));
        //System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6, 7, 8, 9, 10, 12}, 10));
        System.out.println(new Solution().searchInsert(new int[]{1, 2}, -1));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int h = nums.length - 1;
            while (l < h) {
                int mid = (l + h) / 2;
                //System.out.println("l=" + l + ", h=" + h + ", mid=" + mid + ", v=" + nums[mid]);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    h = mid - 1;
                }
            }
            if (nums[l] < target) {
                return l + 1;
            } else {
                return l < 0 ? 0 : l;
            }
        }
    }
}
