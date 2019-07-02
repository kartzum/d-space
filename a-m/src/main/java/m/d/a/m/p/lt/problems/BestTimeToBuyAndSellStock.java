package m.d.a.m.p.lt.problems;

public class BestTimeToBuyAndSellStock {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }

    static class Solution {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }
}
