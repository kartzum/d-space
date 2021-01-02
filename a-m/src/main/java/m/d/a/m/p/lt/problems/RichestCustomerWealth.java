package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class RichestCustomerWealth {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[][] accounts = new int[][]{
                {1, 5},
                {7, 3},
                {3, 5}
        };
        System.out.print(new Solution().maximumWealth(accounts));
    }

    static class Solution {
        public int maximumWealth(int[][] accounts) {
            List<Integer> sum = new ArrayList<>();
            int res = 0;
            int largest = 0;
            for (int row[] : accounts) {
                for (int i : row) {
                    res += i;
                }
                sum.add(res);
                res = 0;
            }

            for (Integer integer : sum) {
                if (largest < integer)
                    largest = integer;
            }
            return largest;
        }
    }
}
