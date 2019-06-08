package m.d.a.m.p.lt.problems;

public class FibonacciNumber {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().fib(3));
    }

    static class Solution {
        public int fib(int n) {
            if (n <= 0)
                return 0;

            if (n == 1)
                return 1;

            int fibMinusTwo = 0;
            int fibMinusOne = 1;

            for (int i = 2; i <= n; i++)
            {
                int tempfib = fibMinusOne;
                fibMinusOne = fibMinusOne + fibMinusTwo;
                fibMinusTwo = tempfib;
            }

            return fibMinusOne;
        }
    }
}
