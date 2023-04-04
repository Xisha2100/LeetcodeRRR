//有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
//
// 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。 
//
// 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [3,2,4,1], K = 2
//输出：20
//解释：
//从 [3, 2, 4, 1] 开始。
//合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
//合并 [4, 1]，成本为 5，剩下 [5, 5]。
//合并 [5, 5]，成本为 10，剩下 [10]。
//总成本 20，这是可能的最小值。
// 
//
// 示例 2： 
//
// 输入：stones = [3,2,4,1], K = 3
//输出：-1
//解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
// 
//
// 示例 3： 
//
// 输入：stones = [3,5,1,2,6], K = 3
//输出：25
//解释：
//从 [3, 5, 1, 2, 6] 开始。
//合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
//合并 [3, 8, 6]，成本为 17，剩下 [17]。
//总成本 25，这是可能的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 2 <= K <= 30 
// 1 <= stones[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 313 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Arrays;

public class MinimumCostToMergeStones {
    public static void main(String[] args) {
        Solution solution = new MinimumCostToMergeStones().new Solution();
        solution.mergeStones(new int[]{3,2,4,1},2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][][] dp;
        private int[][] sum;

        private int k;

        public int mergeStones(int[] stones, int k) {
            if (stones.length % (k - 1) != 1 && k != 2) {
                return -1;
            }
            int len = stones.length;
            dp = new int[len][len][k + 1];
            sum = new int[len][len];
            this.k = k;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    Arrays.fill(dp[i][j], -1);
                    if (i == j) {
                        sum[i][j] = stones[i];
                    } else if (i < j) {
                        sum[i][j] = sum[i][j - 1] + stones[j];
                    }
                }
                dp[i][i][1] = 0;
            }
            int res=func(0, len - 1, 1);
            return res;
        }

        private int func(int l, int r, int t) {
            if (dp[l][r][t] != -1) {
                return dp[l][r][t];
            }

            if (t > r - l + 1) {
                return Integer.MAX_VALUE;
            }

            int res;
            if (t == 1) {
                res = func(l, r, k);
                if (res == Integer.MAX_VALUE) {
                    return res;
                } else {
                    return dp[l][r][t] = res + sum[l][r];
                }
            }

            res = Integer.MAX_VALUE;
            for (int i = l; i < r; i += k - 1) {
                res = Math.min(res, func(l, i, 1) + func(i + 1, r, t - 1));
            }
            return dp[l][r][t] = res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}