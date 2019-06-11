package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class PowXN {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        System.out.println(new Solution().myPow(2, -2));
    }

    static void test3() {
        System.out.println(new Solution3().myPow(2.0, -2));
    }

    static void test2() {
        System.out.println(new Solution2().myPow(21, 13));
        System.out.println(new Solution2().myPow(2, 10));
        System.out.println(new Solution2().myPow(2.1, 3));
    }

    static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (n == 2) return x * x;
            if (n < 0) return 1 / (myPow(x, -n - 1) * x);  //attention the overflow of int when changing from -n to n;
            if (n % 2 == 0) return myPow(myPow(x, n / 2), 2);
            else return x * myPow(x, n - 1);
        }
    }

    static class Solution3 {
        public double myPow(double x, int n) {
            if (n < 0) {
                if (n == Integer.MIN_VALUE) return 1 / x * myPow(1 / x, Integer.MAX_VALUE);
                else return myPow(1 / x, -n);
            }
            if (n == 0) return 1;
            if (n == 1) return x;
            else return (n % 2 != 0) ? x * myPow(x * x, n / 2) : myPow(x * x, n / 2);
        }
    }

    static class Solution2 {
        public double myPow(double x, int n) {

            double r = 1;

            List<Integer> b = new ArrayList<>();
            int k = n;
            while (k > 0) {
                int a = k % 2;
                k = k / 2;
                b.add(0, a);
            }

            for (int i = 0; i < b.size(); i++) {
                int m = b.get(i);
                double z = m == 0 ? 1 : x;

                r = i == b.size() - 1 ? (r * z) : (r * z) * (r * z);
            }

            return r;
        }
    }
}
