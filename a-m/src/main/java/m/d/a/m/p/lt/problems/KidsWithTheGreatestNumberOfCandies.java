package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        List<Boolean> r = new Solution().kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        for (Boolean b : r) {
            System.out.println(b);
        }
    }

    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            ArrayList<Boolean> list = new ArrayList<Boolean>();
            int l = candies.length;
            int max = candies[0];
            for (int i = 0; i < l; i++) {
                if (candies[i] > max)
                    max = candies[i];
            }
            for (int i = 0; i < l; i++) {
                if (candies[i] + extraCandies >= max)
                    list.add(true);
                else
                    list.add(false);
            }
            return list;
        }
    }
}
