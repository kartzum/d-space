package m.d.a.m.p.lt.problems;

public class PowerOfThree {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().isPowerOfThree(3));
    }

    public static class Solution {
        public boolean isPowerOfThree(int n) {
            if (n < 1) {
                return false;
            }

            while (n % 3 == 0) {
                n /= 3;
            }

            return n == 1;
        }
    }
}
