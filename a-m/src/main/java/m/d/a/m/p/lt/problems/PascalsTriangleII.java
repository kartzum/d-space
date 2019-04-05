package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().getRow(3));
    }

    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();

            int numRows = rowIndex + 1;

            if (numRows == 0) {
                return Collections.emptyList();
            }

            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(i - 1);
                row.add(1);
                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                row.add(1);
                triangle.add(row);
            }

            return triangle.get(numRows - 1);
        }
    }
}
