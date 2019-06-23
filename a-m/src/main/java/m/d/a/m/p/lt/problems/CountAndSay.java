package m.d.a.m.p.lt.problems;

public class CountAndSay {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().countAndSay(4));
    }

    static class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";

            StringBuilder res = new StringBuilder();

            String s = countAndSay(n - 1) + "0";
            for (int i = 0, c = 1; i < s.length() - 1; i++, c++) {
                if (s.charAt(i + 1) != s.charAt(i)) {
                    res.append(c).append(s.charAt(i));
                    c = 0;
                }
            }

            return res.toString();

        }
    }
}
