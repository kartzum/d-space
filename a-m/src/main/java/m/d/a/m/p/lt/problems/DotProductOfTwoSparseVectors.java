package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class DotProductOfTwoSparseVectors {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        SparseVector v1 = new SparseVector(new int[]{1, 0, 0, 2, 3});
        SparseVector v2 = new SparseVector(new int[]{0, 3, 0, 4, 0});
        int ans = v1.dotProduct(v2);
        System.out.print(ans);
    }

    static class SparseVector {

        List<int[]> pairs;

        SparseVector(int[] nums) {
            pairs = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    pairs.add(new int[]{i, nums[i]});
                }
            }
        }

        public int dotProduct(SparseVector vec) {
            int result = 0, p = 0, q = 0;
            while (p < pairs.size() && q < vec.pairs.size()) {
                if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                    result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                    p++;
                    q++;
                } else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) {
                    q++;
                } else {
                    p++;
                }
            }
            return result;
        }
    }
}
