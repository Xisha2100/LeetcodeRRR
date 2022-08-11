//给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
//
// 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎
//，则可以在之后的操作中 重复使用 这枚鸡蛋。 
//
// 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？ 
// 
//
// 示例 1： 
//
// 
//输入：k = 1, n = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。 
//否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。 
//如果它没碎，那么肯定能得出 f = 2 。 
//因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。 
// 
//
// 示例 2： 
//
// 
//输入：k = 2, n = 6
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：k = 3, n = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= n <= 10⁴ 
// 
// Related Topics 数学 二分查找 动态规划 👍 856 👎 0


package top.nzhz.leetcode.editor.cn;

public class SuperEggDrop {
    public static void main(String[] args) {
        Solution solution = new SuperEggDrop().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int k, int n) {
            int[][] dp = new int[k + 1][n + 1];

            for (int i = 1; i <= k; i++) {
                dp[i][1] = 1;
            }
            for (int i = 1; i <= n; i++) {
                dp[1][i] = i;
            }
            for (int i = 2; i <= k; i++) {
                for (int j = 2; j <= n; j++) {
                    int left = 1;
                    int right = j;
                    while (left + 1 < right) {
                        int mid = (left + right)/2;
                        int down = dp[i - 1][mid - 1];
                        int up = dp[i][j - mid];
                        if (down > up) {
                            right = mid;
                        } else if (down < up) {
                            left = mid;
                        } else {
                            left = mid;
                            right = mid;
                        }
                    }
                    int leftVal = Math.max(dp[i - 1][left - 1], dp[i][j - left]);
                    int rightVal = Math.max(dp[i - 1][right - 1], dp[i][j - right]);
                    dp[i][j] = 1 + Math.min(leftVal, rightVal);
                }
            }
            return dp[k][n];
        }
//        public int superEggDrop(int k, int n) {
//            if (n == 1) {
//                return 1;
//            }
//            int[][] dp = new int[n + 1][k + 1];
//            for (int i = 1; i <= k; i++) {
//                dp[1][i] = 1;
//            }
//            for (int i = 2; i <= n; i++) {
//                for (int j = 1; j <= k; j++) {
//                    dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
//                }
//                if (dp[i][k] >= n) {
//                    return i;
//                }
//            }
//            return 0;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}