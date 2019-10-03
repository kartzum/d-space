package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(final String[] args) {
        List<List<Integer>> r = new Solution().minimumAbsDifference(new int[]{4, 2, 1, 3});
        for (List<Integer> i : r) {
            System.out.println(i);
        }
    }

    static class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(arr);
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff < minDiff) {
                    res.clear();
                    res.add(Arrays.asList(arr[i - 1], arr[i]));
                    minDiff = diff;
                } else if (diff == minDiff) {
                    res.add(Arrays.asList(arr[i - 1], arr[i]));
                }
            }
            return res;
        }
    }
}
