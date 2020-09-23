package m.d.a.m.p.lt.problems;

public class LongestOnes {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(new Solution().longestOnes(a, 2));
    }

    static class Solution {
        public int longestOnes(int[] A, int K) {
            int left = 0;
            int right = 0;
            for (right = 0; right < A.length; right++) {
                if (A[right] == 0) {
                    K--;
                }
                if (K < 0) {
                    if (A[left] == 0) {
                        K++;
                    }
                    left++;
                }
            }
            return right - left;
        }
    }
}
