package m.d.a.m.p.lt.problems;

import java.util.HashMap;

public class SubArraySumsDivisibleByK {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(new Solution2().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    static class Solution {
        public int subarraysDivByK(int[] A, int K) {
            int N = A.length;
            int[] P = new int[N + 1];
            for (int i = 0; i < N; ++i)
                P[i + 1] = P[i] + A[i];

            int[] count = new int[K];
            for (int x : P)
                count[(x % K + K) % K]++;

            int ans = 0;
            for (int v : count)
                ans += v * (v - 1) / 2;
            return ans;
        }
    }

    static class Solution2 {
        public int subarraysDivByK(int[] A, int K) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int runningSum = 0;
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                runningSum += A[i];
                int remainder = runningSum % K;
                if (remainder < 0) remainder += K;
                if (map.containsKey(remainder)) {
                    count += map.get(remainder);
                }
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            }
            return count;
        }

    }
}
