package m.d.a.m.p.lt.problems;

public class ImplementRand10UsingRand7 {

    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().rand10());
    }

    static abstract class SolBase {
        int rand7() {
            return 0;
        }
    }

    static class Solution extends SolBase {
        public int rand10() {
            int row, col, idx;
            do {
                row = rand7();
                col = rand7();
                idx = col + (row - 1) * 7;
            } while (idx > 40);
            return 1 + (idx - 1) % 10;
        }
    }
}
