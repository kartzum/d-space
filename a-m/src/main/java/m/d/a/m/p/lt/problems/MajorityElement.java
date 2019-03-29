package m.d.a.m.p.lt.problems;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
            int m = Integer.MIN_VALUE;
            int k = -1;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() > m) {
                    m = e.getValue();
                    k = e.getKey();
                }
            }
            return k;
        }
    }
}
