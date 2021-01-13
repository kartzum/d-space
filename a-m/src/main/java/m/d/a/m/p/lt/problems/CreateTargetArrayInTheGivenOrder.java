package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateTargetArrayInTheGivenOrder {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] r = new Solution().createTargetArray(new int[]{0,1,2,3,4}, new int[]{0, 1, 2, 2, 1});
        System.out.println(Arrays.toString(r));
    }

    static class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                list.add(index[i], nums[i]);
            }

            int i = 0;
            int[] result = new int[list.size()];
            for (int val : list) {
                result[i++] = val;
            }

            return result;
        }
    }
}
