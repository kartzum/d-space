package m.d.a.m.p.lt.problems;

public class ReverseWordsInAString {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().reverseWords("the sky is blue"));
    }

    static class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            for (int i = 0; i <= s.length(); i++) {
                if (i == s.length() || s.charAt(i) == ' ') {
                    if (i > start) sb.insert(0, s.substring(start, i) + " ");
                    start = i + 1;
                }
            }
            return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).toString();
        }
    }
}
