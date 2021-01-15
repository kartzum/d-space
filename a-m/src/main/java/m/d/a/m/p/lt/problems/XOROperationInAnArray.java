package m.d.a.m.p.lt.problems;

public class XOROperationInAnArray {
    public static void main(final String[] args) {
        test();
    }

    private static void test() {
        System.out.print(new Solution().xorOperation(5, 0));
    }

    static class Solution {
        public int xorOperation(int n, int start) {
            int ans = (start + 2 * 0);
            for (int i = 1; i < n; i++) {
                ans = (start + 2 * i) ^ ans;
            }
            return ans;
        }
    }
}
