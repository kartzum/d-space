package m.d.a.m.p.lt.problems;

public class ValidPalindrome {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            int start = 0;
            int finish = s.length() - 1;
            while (start < finish) {
                if (!Character.isLetterOrDigit(s.charAt(start))) {
                    start++;
                    continue;
                }
                if (!Character.isLetterOrDigit(s.charAt(finish))) {
                    finish--;
                    continue;
                }
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(finish))) {
                    return false;
                }
                start++;
                finish--;
            }
            return true;
        }
    }
}
