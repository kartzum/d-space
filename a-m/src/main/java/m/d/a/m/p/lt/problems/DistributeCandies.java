package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class DistributeCandies {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().distributeCandies(new int[]{1}));
    }

    static class Solution {
        public int distributeCandies(int[] candies) {
            Arrays.sort(candies);
            int count = 1;
            for (int i = 1; i < candies.length && count < candies.length / 2; i++)
                if (candies[i] > candies[i - 1])
                    count++;
            return count;
        }
    }

}
