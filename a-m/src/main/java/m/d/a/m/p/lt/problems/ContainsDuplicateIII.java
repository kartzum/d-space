package m.d.a.m.p.lt.problems;

public class ContainsDuplicateIII {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        int[] arr = new int[]{1, 2, 3, 1};
        boolean r = new Solution().containsNearbyAlmostDuplicate(arr, 3, 0);
        System.out.println(r);
    }

    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] n, int k, int t) {
            if (n.length <= 1) return false;
            for (int i = 0; i < n.length; i++) {
                for (int j = i + 1; j < n.length && j < i + 1 + k; j++) {
                    if (Math.abs((long) n[i] - (long) n[j]) <= (long) t) return true;
                }
            }
            return false;
        }
    }
}
