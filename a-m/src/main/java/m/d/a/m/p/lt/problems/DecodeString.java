package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution().decodeString("3[a]2[b4[F]c]"));
    }

    public static class Solution {
        private String decodeString(String s) {
            if (s == null || s.length() == 0) return "";
            List<String> tokens = new ArrayList<>();
            final StringBuilder n = new StringBuilder();
            final StringBuilder t = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    if (t.length() > 0) {
                        tokens.add(t.toString());
                        t.setLength(0);
                    }
                    n.append(c);
                } else if (c == '[') {
                    if (n.length() > 0) {
                        tokens.add(n.toString());
                        n.setLength(0);
                    }
                    tokens.add("[");
                } else if (c == ']') {
                    if (t.length() > 0) {
                        tokens.add(t.toString());
                        t.setLength(0);
                    }
                    tokens.add("]");
                } else {
                    t.append(c);
                    if (i == s.length() - 1) {
                        tokens.add(t.toString());
                    }
                }
            }
            final Stack<String> stack = new Stack<>();
            int i = 0;
            do {
                final String token = tokens.get(i);
                if (token.equals("]")) {
                    String v1 = stack.pop();
                    String n1 = stack.pop();
                    int l;
                    String q = "";
                    if (Character.isDigit(n1.charAt(0))) {
                        l = new Integer(n1);
                        q = v1;
                    } else {
                        while (!Character.isDigit(n1.charAt(0))) {
                            q = n1 + q + v1;
                            n1 = stack.pop();
                            v1 = "";
                        }
                        l = new Integer(n1);
                    }
                    final StringBuilder r = new StringBuilder();
                    for (int j = 0; j < l; j++) {
                        r.append(q);
                    }
                    stack.push(r.toString());
                    i++;
                } else {
                    if (!token.equals("[")) {
                        stack.push(token);
                    }
                    i++;
                }
            } while (i < tokens.size());
            final StringBuilder buf = new StringBuilder();
            for (String s1 : stack) {
                buf.append(s1);
            }
            return buf.toString();
        }
    }
}
