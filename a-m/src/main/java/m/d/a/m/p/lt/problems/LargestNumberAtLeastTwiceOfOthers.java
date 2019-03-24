package m.d.a.m.p.lt.problems;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().dominantIndex(new int[]{3, 6, 1, 0}));
    }

    static class Solution {
        public int dominantIndex(int[] nums) {
            int m = Integer.MIN_VALUE;
            int k = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > m) {
                    m = nums[i];
                    k = i;
                }
            }
            System.out.println(m + ", " + k);
            for (int n = 0; n < nums.length; n++) {
                if (n != k && m < 2 * nums[n]) {
                    k = -1;
                    break;
                }
            }
            return k;
        }
    }
}
