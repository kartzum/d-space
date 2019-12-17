package m.d.a.m.p.lt.problems;

public class BackspaceStringCompare {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.print(new Solution().backspaceCompare("ab#c", "ad#c"));
        System.out.print(new Solution().backspaceCompare("ab##", "c#d#"));
    }

    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            if (S == null || T == null) {
                return false;
            }
            String s1 = prepare(S);
            String t1 = prepare(T);
            //System.out.println(s1 + ", " + t1);
            //System.out.println();
            return s1.equals(t1);
        }

        private String prepare(String t) {
            StringBuilder b = new StringBuilder();
            char[] chars = t.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '#') {
                    if (b.length() > 0) {
                        b.deleteCharAt(b.length() - 1);
                    }
                } else {
                    b.append(c);
                }
            }
            return b.toString();
        }
    }
}
