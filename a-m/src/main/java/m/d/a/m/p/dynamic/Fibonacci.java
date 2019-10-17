package m.d.a.m.p.dynamic;

/**
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * 0, 1, 2, 3, 4, 5, 6, 7,  8,  9,  10, 11, 12...
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 * f[0] = 0;
 * f[1] = 1;
 */
public class Fibonacci {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution1().calc(10));
        System.out.println(new Solution2().calc(10));
        System.out.println(new Solution3().calc(10));
    }

    static class Solution1 {
        int calc(int n) {
            if (n <= 1)
                return n;
            return calc(n - 1) + calc(n - 2);
        }
    }

    static class Solution2 {
        int calc(int n) {
            int[] f = new int[n + 2];
            f[0] = 0;
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }
    }

    static class Solution3 {
        int calc(int n) {
            int n2 = 0;
            int n1 = 1;
            if (n <= 0) {
                return 0;
            }
            for (int i = 2; i <= n; i++) {
                int c = n2 + n1;
                n2 = n1;
                n1 = c;
            }
            return n1;
        }
    }
}
