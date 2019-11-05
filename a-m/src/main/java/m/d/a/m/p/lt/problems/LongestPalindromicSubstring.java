package m.d.a.m.p.lt.problems;

public class LongestPalindromicSubstring {
    public static void main(final String[] args) {
        // test1();
        test2();
    }

    static void test1() {
        String s = new Solution1().longestPalindrome("dabcba");
        System.out.println(s);
    }

    static void test2() {
        String s = new Solution2().longestPalindrome("dabcba");
        System.out.println(s);
    }

    static class Solution1 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1)
                return s;

            int len = s.length();
            int maxLen = 1;
            boolean[][] dp = new boolean[len][len];

            String longest = null;
            for (int l = 0; l < s.length(); l++) {
                for (int i = 0; i < len - l; i++) {
                    int j = i + l;
                    // System.out.println(i + ", " + j);
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;

                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            longest = s.substring(i, j + 1);
                        }
                    }
                }
                // System.out.println();
            }

            return longest;
        }
    }

    static class Solution2 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            int start = 0;
            int end = 0;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    // System.out.println(j + ", " + i);
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                    }
                    if (dp[j][i] && max < i - j + 1) {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
                // System.out.println();
            }
            return s.substring(start, end + 1);
        }
    }
}
