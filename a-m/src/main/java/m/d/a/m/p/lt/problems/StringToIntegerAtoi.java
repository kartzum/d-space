package m.d.a.m.p.lt.problems;

public class StringToIntegerAtoi {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println("42= " + new Solution().myAtoi("42"));
        System.out.println("42= " + new Solution().myAtoi("  42"));
        System.out.println("-42= " + new Solution().myAtoi("   -42"));
        System.out.println("4193= " + new Solution().myAtoi("4193 with words"));
        System.out.println("0= " + new Solution().myAtoi("words and 987"));
        System.out.println("-2147483648= " + new Solution().myAtoi("-91283472332"));
        System.out.println("3= " + new Solution().myAtoi("3.14159"));
        System.out.println("1= " + new Solution().myAtoi("+1"));
        System.out.println("0= " + new Solution().myAtoi("+-2"));
        System.out.println("2147483647= " + new Solution().myAtoi("9223372036854775808"));
        System.out.println("-5= " + new Solution().myAtoi("-5-"));
        System.out.println("-13= " + new Solution().myAtoi("-13+8"));
    }

    static class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            long n = 0;
            int k = 1;
            String t = str.trim();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (Character.isDigit(c)) {
                    int z = Character.getNumericValue(c);
                    n = n * 10 + z;
                    if(n > Integer.MAX_VALUE) {
                        break;
                    }
                } else if (c == '-') {
                    if (i > 0) {
                        break;
                    }
                    k = -1;
                } else if (c == '+') {
                    if (i > 0) {
                        break;
                    }
                    k = 1;
                } else {
                    break;
                }
            }
            long r = 0;
            if (n * k > Integer.MAX_VALUE) {
                r = Integer.MAX_VALUE;
            } else if (n * k < Integer.MIN_VALUE) {
                r = Integer.MIN_VALUE;
            } else {
                r = n * k;
            }
            return (int) r;
        }
    }
}
