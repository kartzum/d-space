package m.d.a.m.p.lt.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    static class Solution {
        int[] twoSum(int[] nums, int target) {
            final Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int j = 0; j < nums.length; j++) {
                final int t = target - nums[j];
                if (map.containsKey(t) && map.get(t) != j) {
                    return new int[]{j, map.get(t)};
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
