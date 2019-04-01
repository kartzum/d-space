package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(t1);
            return Arrays.equals(s1, t1);
        }
    }
}
