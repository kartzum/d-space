package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumOfTwoLists {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(new Solution().findRestaurant(list1, list2)));
    }

    public static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            HashMap<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                for (int j = 0; j < list2.length; j++) {
                    if (list1[i].equals(list2[j])) {
                        if (!map.containsKey(i + j))
                            map.put(i + j, new ArrayList<String>());
                        map.get(i + j).add(list1[i]);
                    }
                }
            }
            int min_index_sum = Integer.MAX_VALUE;
            for (int key : map.keySet())
                min_index_sum = Math.min(min_index_sum, key);
            String[] res = new String[map.get(min_index_sum).size()];
            return map.get(min_index_sum).toArray(res);
        }
    }
}
