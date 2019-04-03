package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        List<List<Integer>> triangle = new Solution().generate(5);
        for (List<Integer> t : triangle) {
            System.out.println(t);
        }
    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();

            if (numRows == 0) {
                return triangle;
            }

            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            for (int rowNum = 1; rowNum < numRows; rowNum++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(rowNum - 1);

                row.add(1);

                for (int j = 1; j < rowNum; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                row.add(1);

                triangle.add(row);
            }

            return triangle;
        }
    }
}
