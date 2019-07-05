package m.d.a.m.p.lt.problems;

public class ReverseBits {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().reverseBits(10));
    }

    public static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++, n = n >> 1) {
                if ((n & 1) == 1) ans++;
                if (i != 31) ans *= 2;
            }
            return ans;
        }
    }
}
