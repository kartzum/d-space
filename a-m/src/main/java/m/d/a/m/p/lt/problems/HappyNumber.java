package m.d.a.m.p.lt.problems;

public class HappyNumber {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().isHappy(19));
    }

    static class Solution {
        public boolean isHappy(int n) {
            int l = 0;
            int s = n;
            do {
                int k = s;
                int p = 0;
                while (k > 0) {
                    int d = k % 10;
                    k = k / 10;
                    p = p + d * d;
                }

                if (p == 1) {
                    return true;
                }

                s = p;

                if (l > 10000) {
                    break;
                }
                l++;
            } while (true);
            return false;
        }
    }
}
