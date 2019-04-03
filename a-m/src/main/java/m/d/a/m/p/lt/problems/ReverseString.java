package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class ReverseString {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        char[] h = new char[]{'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(h);
        System.out.println(Arrays.toString(h));
    }

    static class Solution {
        public void reverseString(char[] s) {
            if (s == null || s.length <= 1) {
                return;
            }
            int i = 0;
            int j = s.length - 1;
            while (i < j) {
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
                i++;
                j--;
            }
        }
    }

}
