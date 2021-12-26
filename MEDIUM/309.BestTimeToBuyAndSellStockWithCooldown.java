//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 数组 动态规划 👍 996 👎 0


package top.nzhz.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            int holdProfit=-prices[0],notHoldProfit1=0,notHoldProfit0=0;
            for (int i = 1; i < prices.length; i++) {
                holdProfit=Math.max(holdProfit,notHoldProfit0-prices[i]);
                notHoldProfit0=notHoldProfit1;
                notHoldProfit1=Math.max(notHoldProfit1,holdProfit+prices[i]);
            }

            return Math.max(holdProfit,notHoldProfit1);
        }

//        public int maxProfit(int[] prices) {
//
//            if (prices.length <= 1) return 0;
//            int[][] dp = new int[prices.length][2];
//            dp[0][0] = -prices[0];
//            dp[1][0] = Math.max(-prices[0], -prices[1]);
//            dp[1][1] = Math.max(0, prices[1] - prices[0]);
//            for (int i = 2; i < prices.length; i++) {
//                dp[i][0] = Math.max(dp[i - 2][1] - prices[i], dp[i - 1][0]);
//                dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
//            }
//
//            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}