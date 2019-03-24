package m.d.a.m.p.lt.problems;

public class FindPivotIndex {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            System.out.println(sum);
            int leftsum = 0;
            for (int i = 0; i < nums.length; ++i) {
                System.out.println("leftsum=" + leftsum + ", i=" + i + ", s=" + (sum - leftsum - nums[i]));
                if (leftsum == sum - leftsum - nums[i]) {
                    return i;
                }
                leftsum += nums[i];
            }
            return -1;
        }
    }
}
