//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 👍 955 👎 0


package top.nzhz.leetcode.editor.cn;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        solution.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int len = matrix.length, wid = matrix[0].length;
            int[][] dp = new int[len][wid];
            int ans=0;

            for (int i = 0; i < len; i++) {
                if (matrix[i][0] == '1') {
                    dp[i][0] = 1;
                    ans=1;
                } else {
                    dp[i][0] = 0;
                }
            }
            for (int i = 1; i < wid; i++) {
                if (matrix[0][i] == '1') {
                    dp[0][i] = 1;
                    ans=1;
                } else {
                    dp[0][i] = 0;
                }
            }

            for (int i = 1; i < len; i++) {
                for (int j = 1; j < wid; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]))+1;
                        ans = Math.max(ans, dp[i][j]*dp[i][j]);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}