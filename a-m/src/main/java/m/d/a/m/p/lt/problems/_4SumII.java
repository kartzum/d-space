package m.d.a.m.p.lt.problems;

import java.util.HashMap;
import java.util.Map;

public class _4SumII {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{-2, -1};
        int[] c = new int[]{-1, 2};
        int[] d = new int[]{0, 2};
        System.out.println(new Solution().fourSumCount(a, b, c, d));
    }

    static class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int count = 0;
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int numA : A) {
                for (int numB : B) {
                    int sumAB = numA + numB;
                    hashMap.put(sumAB, hashMap.getOrDefault(sumAB, 0) + 1);
                }
            }
            for (int numC : C) {
                for (int numD : D) {
                    int sumCD = numC + numD;
                    count += hashMap.getOrDefault(-sumCD, 0);
                }
            }
            return count;
        }
    }
}
