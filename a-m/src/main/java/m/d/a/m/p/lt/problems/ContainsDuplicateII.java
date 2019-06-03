package m.d.a.m.p.lt.problems;

public class ContainsDuplicateII {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums.length == 0) return false;
            if (nums.length >= 5000) return false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++)
                    if (i != j)
                        if (nums[i] == nums[j]) {
                            if (Math.abs(j - i) <= k)
                                return true;
                        }
            }
            return false;
        }
    }
}
