package m.d.a.m.p.lt.problems;

public class MaximumSubarray {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{1}));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int m = nums[0];
            int c = nums[0];
            for (int i = 1; i < nums.length; i++) {
                c += nums[i];

                if (c < nums[i]) {
                    c = nums[i];
                }
                if (m < c) {
                    m = c;
                }
            }
            return m;
        }
    }

    static class Solution3 {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int t = nums[0];
            int m = t;

            for (int i = 0; i < nums.length; i++) {
                if (t < 0) {
                    t = nums[i];
                } else {
                    t += nums[i];
                }
                m = Math.max(m, t);
            }

            return m;
        }
    }

    static class Solution2 {
        public int maxSubArray(int[] nums) {
            return maxSubArrayInner(nums, 0, nums.length - 1);
        }

        int maxSubArrayInner(int[] nums, int l, int r) {
            if (l == r) {
                return nums[l];
            }

            int mid = l + (r - l) / 2;

            int maxL = maxSubArrayInner(nums, l, mid);
            int maxR = maxSubArrayInner(nums, mid + 1, r);
            int maxS = Math.max(maxL, maxR);

            int s1 = 0;
            int m1 = Integer.MIN_VALUE;
            for (int i = mid + 1; i <= r; ++i) {
                s1 += nums[i];
                m1 = Math.max(m1, s1);
            }

            int s2 = 0;
            int m2 = Integer.MIN_VALUE;
            for (int i = mid; i >= l; --i) {
                s2 += nums[i];
                m2 = Math.max(m2, s2);
            }

            return Math.max(maxS, s1 + s2);
        }
    }
}
