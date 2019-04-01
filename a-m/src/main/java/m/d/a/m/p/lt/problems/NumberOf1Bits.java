package m.d.a.m.p.lt.problems;

public class NumberOf1Bits {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().hammingWeight(3));
    }

    public static class Solution {
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            System.out.println(Integer.toBinaryString(n));
            for (int i = 0; i < 32; i++) {
                System.out.println("mask: " + mask + ", b = " + Integer.toBinaryString(mask));
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }
}
