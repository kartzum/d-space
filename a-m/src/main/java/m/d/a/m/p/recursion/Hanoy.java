package m.d.a.m.p.recursion;

public class Hanoy {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        new Solution().execute(3, 'A', 'B', 'C');
    }

    private static class Solution {
        void execute(int n, char a, char b, char c) {
            if (n > 0) {
                execute(n - 1, a, c, b);
                System.out.println(a + "->" + c);
                execute(n - 1, b, a, c);
            }
        }
    }
}
