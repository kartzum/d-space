package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        int[] a = new int[]{-4, -1, 0, 3, 10};
        int[] r = new Solution().sortedSquares(a);
        System.out.println(Arrays.toString(r));
    }

    static class Solution {
        public int[] sortedSquares(int[] A) {
            for (int i = 0; i < A.length; i++) {
                A[i] = A[i] * A[i];
            }
            Arrays.sort(A);
            return A;
        }
    }
}
