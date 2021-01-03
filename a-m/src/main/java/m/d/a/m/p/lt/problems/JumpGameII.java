package m.d.a.m.p.lt.problems;

public class JumpGameII {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.print(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }

    static class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            if (n < 2) return 0;

            // max position one could reach
            // starting from index <= i
            int maxPos = nums[0];
            // max number of steps one could do
            // inside this jump
            int maxSteps = nums[0];

            int jumps = 1;
            for (int i = 1; i < n; ++i) {
                // if to reach this point
                // one needs one more jump
                if (maxSteps < i) {
                    ++jumps;
                    maxSteps = maxPos;
                }
                maxPos = Math.max(maxPos, nums[i] + i);
            }
            return jumps;
        }
    }

    static class Solution2 {
        public boolean canJump(int[] nums) {
            int n = nums.length;

            // max position one could reach
            // starting from index <= i
            int maxPos = nums[0];

            for (int i = 1; i < n; ++i) {
                // if one could't reach this point
                if (maxPos < i) {
                    return false;
                }
                maxPos = Math.max(maxPos, nums[i] + i);
            }
            return true;
        }
    }
}
