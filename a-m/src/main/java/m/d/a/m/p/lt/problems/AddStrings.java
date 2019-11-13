package m.d.a.m.p.lt.problems;

public class AddStrings {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().addStrings("18", "89"));
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            char[] n1 = null;
            char[] n2 = null;
            if (num1.length() > num2.length()) {
                n1 = num1.toCharArray();
                n2 = num2.toCharArray();
            } else {
                n1 = num2.toCharArray();
                n2 = num1.toCharArray();
            }
            int b = n1.length - 1;
            int s = n2.length - 1;
            int t = 0;
            StringBuilder buf = new StringBuilder();
            while (b >= 0) {
                int c1 = Character.getNumericValue(n1[b]);
                int c2 = s >= 0 ? Character.getNumericValue(n2[s]) : 0;

                int v = c1 + c2 + t;
                int r = v % 10;
                t = v / 10;

                // System.out.println(c1 + "," + c2 + ", " + r);
                buf.append(r);

                b = b - 1;
                s = s - 1;
            }
            if (t > 0) {
                // System.out.println(t);
                buf.append(t);
            }
            return buf.reverse().toString();
        }
    }
}
