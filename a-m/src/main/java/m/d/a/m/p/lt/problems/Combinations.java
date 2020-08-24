package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        List<List<Integer>> r = new Solution().combine(4, 2);
        for (List<Integer> i : r) {
            System.out.println(i);
        }
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> output_arr = new ArrayList<>();
            backtrack(output_arr, new ArrayList<>(), k, n, 1);
            return output_arr;
        }

        void backtrack(List<List<Integer>> output_arr, List<Integer> tempList, int listSize, int maxNumber, int start) {
            if (tempList.size() == listSize) {
                output_arr.add(new ArrayList<>(tempList));
            } else {
                for (int i = start; i <= maxNumber; i++) {
                    tempList.add(i);
                    backtrack(output_arr, tempList, listSize, maxNumber, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

}
