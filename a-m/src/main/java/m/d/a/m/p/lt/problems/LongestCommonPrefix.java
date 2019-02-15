package m.d.a.m.p.lt.problems;

public class LongestCommonPrefix {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"fl1ower", "fl1ow", "fl1ight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"a"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"aca", "cba"}));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null) return "";
            if (strs.length == 0) return "";
            int m = strs[0].length();
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < m) {
                    m = strs[i].length();
                }
            }
            if (m == 0) return "";
            final StringBuilder b = new StringBuilder();
            for (int i = 0; i < m; i++) {
                final Character c0 = strs[0].charAt(i);
                int k = 0;
                for (int j = 1; j < strs.length; j++) {
                    final Character cj = strs[j].charAt(i);
                    if (c0 == cj) {
                        k += 1;
                    } else {
                        break;
                    }
                }
                if (k == strs.length - 1) {
                    b.append(c0);
                } else {
                    break;
                }
            }
            return b.toString();
        }
    }
}
