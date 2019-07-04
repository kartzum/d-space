package m.d.a.m.p.lt.problems;

public class CountPrimes {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.print(new Solution().countPrimes(10));
    }

    static class Solution {
        public int countPrimes(int n) {
            //Sieve
            if (n <= 2) return 0;
            boolean sieve[] = new boolean[n + 1];
            sieve[2] = true;
            for (int i = 3; i < n; i += 2) {
                sieve[i] = true;
            }

            for (int p = 3; p * p <= n; p++) {
                if (sieve[p]) {
                    for (int i = p + p; i <= n; i += p) {
                        sieve[i] = false;
                    }
                }
            }
            int count = 1;
            for (int i = 3; i < n; i += 2) {
                count += sieve[i] ? 1 : 0;
            }
            return count;
        }
    }
}
