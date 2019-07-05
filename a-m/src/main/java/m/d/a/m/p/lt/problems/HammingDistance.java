package m.d.a.m.p.lt.problems;

public class HammingDistance {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().hammingDistance(1, 4));
    }

    static class Solution {
        public int hammingDistance(int x, int y) {
            int res = 0;

            for (int i = 0; i < 32; i++) {
                int l1 = x & 1; // get last bit of x
                int l2 = y & 1; // get last bit of y
                if (l1 != l2) res++;    // compare
                x = x >> 1; // shift x right by 1 bit
                y = y >> 1; // shift y right by 1 bit
            }

            return res;
        }
    }
}
