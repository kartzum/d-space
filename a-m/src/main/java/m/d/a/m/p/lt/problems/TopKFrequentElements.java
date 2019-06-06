package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        List<Integer> r = new Solution().topKFrequent(nums, 2);
        for (int m : r) {
            System.out.println(m);
        }
    }

    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int num : nums) {
                m.put(num, m.getOrDefault(num, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> items = new ArrayList<>(m.entrySet());

            items.sort((a, b) -> b.getValue() - a.getValue());

            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (i < items.size()) {
                    r.add(items.get(i).getKey());
                }
            }

            return r;
        }
    }
}
