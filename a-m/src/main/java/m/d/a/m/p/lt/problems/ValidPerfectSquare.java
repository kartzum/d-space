package m.d.a.m.p.lt.problems;

public class ValidPerfectSquare {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().isPerfectSquare(16));
        System.out.println(new Solution().isPerfectSquare(14));
        System.out.println(new Solution().isPerfectSquare(324));
        System.out.println(new Solution().isPerfectSquare(323));
    }

    static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 1) return false;
            for (int i = 1; num > 0; i += 2) {
                num -= i;
            }
            return num == 0;
        }

        public boolean isPerfectSquare2(int num) {
            if (num < 0) return false;
            int k = 0;
            int i = 0;
            while (i <= num) {
                if (i % 2 != 0) {
                    k += i;
                }
                if (k == num) return true;
                i++;
            }
            return false;
        }
    }
}
