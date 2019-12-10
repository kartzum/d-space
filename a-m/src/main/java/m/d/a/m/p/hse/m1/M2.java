package m.d.a.m.p.hse.m1;

public class M2 {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        System.out.println(new Calculator1().calc(4));
        System.out.println(new Calculator2().calc(4));
        System.out.println(new Calculator3().calc(4));
    }

    private static void test2() {
        System.out.println(new Calculator3().calc(7));
    }

    public static class Calculator1 {
        int ans;
        int[] a;
        int n;

        int calc(int n) {
            ans = 0;
            a = new int[n];
            this.n = n;
            helper(0, 0);
            return ans;
        }

        void helper(int i, int s) {
            if (s > n) {
                return;
            }
            if (s == n) {
                ans++;
                return;
            }
            a[i] = 1;
            helper(i + 1, s + 1);
            a[i] = 2;
            helper(i + 1, s + 2);
        }
    }

    public static class Calculator2 {
        int ans;
        int n;

        int calc(int n) {
            ans = 0;
            this.n = n;
            helper(0, 0);
            return ans;
        }

        void helper(int i, int s) {
            if (s > n) {
                return;
            }
            if (s == n) {
                ans++;
                return;
            }
            helper(i + 1, s + 1);
            helper(i + 1, s + 2);
        }
    }

    public static class Calculator3 {
        int ans;
        int n = 0;

        int calc(int n) {
            ans = 0;
            this.n = n;
            helper(0);
            return ans;
        }

        void helper(int s) {
            if (s > n) {
                return;
            }
            if (s == n) {
                ans++;
                return;
            }
            helper(s + 1);
            helper(s + 2);
        }
    }
}
