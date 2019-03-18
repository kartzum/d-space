package m.d.a.m.p.lt.problems;

public class Sqrt {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().mySqrt(9));
    }

    static class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            long r = x;
            while (r * r > x) {
                r = (r + x / r) / 2;
                System.out.println(r);
            }
            return (int) r;
        }
    }

    static class Solution2 {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            int start = 1;
            int end = x;
            int r = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (mid * mid == x) {
                    return mid;
                }
                if (mid * mid < x) {
                    start = mid + 1;
                    r = mid;
                } else {
                    end = mid - 1;
                }
            }
            return r;
        }
    }
}
