package m.d.a.m.p.lt.problems;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("2", "28"));
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            int len1 = num1.length();
            int len2 = num2.length();
            int[] nums = new int[len1 + len2];
            for (int i = len1 - 1; i >= 0; i--) {
                int v1 = Character.getNumericValue(num1.charAt(i));
                for (int j = len2 - 1; j >= 0; j--) {
                    int v2 = Character.getNumericValue(num2.charAt(j));
                    int m = v1 * v2;
                    int s = nums[i + j + 1] + m;
                    nums[i + j + 1] = s % 10;
                    nums[i + j] += s / 10;
                }
            }
            StringBuilder b = new StringBuilder();
            for (int n : nums) {
                if (b.length() != 0 || n != 0) {
                    b.append(n);
                }
            }
            return b.toString();
        }
    }
}
