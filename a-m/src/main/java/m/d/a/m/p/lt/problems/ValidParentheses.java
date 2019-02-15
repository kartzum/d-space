package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(String.format("true, %b", new Solution().isValid("()")));
        System.out.println(String.format("true, %b", new Solution().isValid("()[]{}")));
        System.out.println(String.format("false, %b", new Solution().isValid("(]")));
        System.out.println(String.format("false, %b", new Solution().isValid("([)]")));
        System.out.println(String.format("true, %b", new Solution().isValid("{[]}")));
        System.out.println(String.format("false, %b", new Solution().isValid("]")));
        System.out.println(String.format("false, %b", new Solution().isValid("}")));
    }

    static class Solution {
        public boolean isValid(String s) {
            final List<Character> l = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']') {
                    if (l.size() > 0) {
                        final Character ch = l.get(l.size() - 1);
                        if ((c == ')' && ch == '(') || (c == '}' && ch == '{') || (c == ']' && ch == '[')) {
                            l.remove(l.size() - 1);
                        } else {
                            l.add(c);
                        }
                    } else {
                        l.add(c);
                    }
                }
            }
            return l.size() == 0;
        }
    }
}
