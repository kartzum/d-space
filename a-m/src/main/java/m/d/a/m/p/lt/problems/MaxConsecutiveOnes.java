package m.d.a.m.p.lt.problems;

public class MaxConsecutiveOnes {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1)
                    count++;
                else {
                    if (count > max)
                        max = count;
                    count = 0;
                }
            }
            return Math.max(max, count);
        }
    }
}
