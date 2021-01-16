package m.d.a.m.p.lt.problems;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public static void main(final String[] args) {
        test();
    }

    private static void test() {
        System.out.println(new Solution().countPairs(new int[]{1, 3, 5, 7, 9}));
    }

    static class Solution {
        int mod = 1000000007;

        public int countPairs(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = arr.length;
            long res = 0;
            for (int num : arr) {
                int power = 1;
                for (int i = 0; i < 22; i++) {
                    if (map.containsKey(power - num)) {
                        res += map.get(power - num);
                        res %= mod;
                    }
                    power *= 2;
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return (int) res;
        }
    }
}
