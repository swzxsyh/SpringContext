package com.test.application.algorithm.leetCode;


/**
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode122 {

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {7, 6, 4, 3, 1};
        int result = maxProfit(prices);
        System.out.println("max profit: " + result);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit;


        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i] < prices[i + 1]) {

                System.out.println("today price:" + -prices[i] + "   tomorrow:" + prices[i + 1]);
                currentProfit = -prices[i] + prices[i + 1];
                maxProfit += currentProfit;
            }
        }


        return maxProfit;
    }
}
