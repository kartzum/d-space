package m.d.a.m.p.lt.problems;

public class KThSymbolInGrammar {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().kthGrammar(4, 5));
    }

    static class Solution {
        public int kthGrammar(int N, int K) {
            return helper(N, K - 1);
        }

        public int helper(int N, int K) {
            if (N == 1 || K == 0) return 0;
            else {
                if (K % 2 == 0) return helper(N - 1, K / 2);
                else return helper(N - 1, K / 2) ^ 1;
            }
        }
    }
}
