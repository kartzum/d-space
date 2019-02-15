package m.d.a.m.p.lt.problems;

public class PalindromeNumber {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(-10));
        System.out.println(new Solution().isPalindrome(72327));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int a = 0;
            int n = x;
            while (n > 0) {
                a = a * 10 + n % 10;
                System.out.println(String.format("a = %d, n = %d", a, n % 10));
                n = n / 10;
                System.out.println(String.format("n = %d", n));
            }
            System.out.println(String.format("a = %d", a));
            return a == x;
        }
    }
}
