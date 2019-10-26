package m.d.a.m.p.lt.problems;

public class SubArraySumsDivisibleByK {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
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
}
