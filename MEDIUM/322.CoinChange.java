//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1623 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{1,2,5},11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            Arrays.sort(coins);
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    int loc = i - coins[j];
                    if (loc < 0) {
                        break;
                    } else if (loc == 0) {
                        dp[i] = 1;
                        break;
                    } else {
                        if (dp[loc] == -1) {
                            continue;
                        }
                        if (dp[i] == 0) {
                            dp[i] = dp[loc] + 1;
                        } else {
                            dp[i] = Math.min(dp[i], dp[loc] + 1);
                        }
                    }
                }
                if (dp[i] == 0) dp[i] = -1;
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}