package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSorted {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        int[] r1 = new Solution1().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(r1));
    }

    static class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int[] r = new int[]{-1, -1};
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    r[0] = i;
                    break;
                }
            }
            if (r[0] == -1) {
                return r;
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] == target) {
                    r[1] = j;
                    break;
                }
            }
            return r;
        }
    }
}
