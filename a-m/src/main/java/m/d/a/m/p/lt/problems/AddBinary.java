package m.d.a.m.p.lt.problems;

public class AddBinary {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().addBinary("11", "1"));
    }

    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int indexA = a.length() - 1, indexB = b.length() - 1, carry = 0;
            while (indexA >= 0 || indexB >= 0) {
                int tempA = indexA >= 0 ? Character.getNumericValue(a.charAt(indexA)) : 0;
                int tempB = indexB >= 0 ? Character.getNumericValue(b.charAt(indexB)) : 0;
                int tempSum = (tempA + tempB + carry);
                sb.insert(0, tempSum % 2);
                carry = tempSum / 2;
                indexA--;
                indexB--;
            }
            if (carry != 0) sb.insert(0, carry);
            return sb.toString();
        }
    }
}
