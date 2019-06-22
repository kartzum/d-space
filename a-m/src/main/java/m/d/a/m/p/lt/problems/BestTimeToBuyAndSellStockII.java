package m.d.a.m.p.lt.problems;

public class BestTimeToBuyAndSellStockII {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int i = 0;
            int valley = prices[0];
            int peak = prices[0];
            int maxprofit = 0;
            while (i < prices.length - 1) {
                while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                    i++;
                valley = prices[i];
                while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                    i++;
                peak = prices[i];
                maxprofit += peak - valley;
            }
            return maxprofit;
        }
    }
}
