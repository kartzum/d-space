package m.d.a.m.p.lt.problems;

public class ReverseInteger {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().reverse(123));
    }

    static class Solution {
        public int reverse(int x) {
            int rev = 0;

            while (x != 0) {
                int pop = x % 10;
                x = x / 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
//                System.out.println(pop + ", " + x + ", " + rev);
            }

            return rev;
        }
    }
}
