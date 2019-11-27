package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        String[] source = new String[]{
                "/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"
        };
        List<String> r = new Solution().removeComments(source);
        for (String s : r) {
            System.out.println(s);
        }
    }

    static class Solution {
        public List<String> removeComments(String[] source) {
            List<String> r = new ArrayList<>();
            StringBuilder b = new StringBuilder();
            boolean inBlock = false;
            for (String s : source) {
                char[] a = s.toCharArray();
                int i = 0;
                if (!inBlock) {
                    b = new StringBuilder();
                }
                while (i < a.length) {
                    if (!inBlock && i + 1 < a.length && a[i] == '/' && a[i + 1] == '*') {
                        inBlock = true;
                        i++;
                    } else if (inBlock && i + 1 < a.length && a[i] == '*' && a[i + 1] == '/') {
                        inBlock = false;
                        i++;
                    } else if (!inBlock && i + 1 < a.length && a[i] == '/' && a[i + 1] == '/') {
                        break;
                    } else if (!inBlock) {
                        b.append(a[i]);
                    }
                    i++;
                }
                if (b.length() > 0 && !inBlock) {
                    r.add(b.toString());
                }
            }
            return r;
        }
    }
}
