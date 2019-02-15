package m.d.a.m.p.lt.problems;

public class ImplementStrStr {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().strStr("ll", "ll"));
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("aaaaa", "bba"));
        System.out.println(new Solution().strStr("bbcc", "cc"));
        System.out.println(new Solution().strStr("bbcc", "ccc"));
        System.out.println(new Solution().strStr("", ""));
        System.out.println(new Solution().strStr("", "aa"));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack != null && needle != null) {
                if (haystack.equals(needle)) {
                    return 0;
                }
                for (int i = 0; i < haystack.length(); i++) {
                    int k = 0;
                    boolean r = true;
                    for (int j = 0; j < needle.length(); j++) {
                        if (i + k < haystack.length()) {
                            final Character h = haystack.charAt(i + k);
                            final Character n = needle.charAt(j);
                            if (h != n) {
                                r = false;
                                break;
                            }
                            k += 1;
                        }
                    }
                    if (r && k == needle.length()) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
    }
}
