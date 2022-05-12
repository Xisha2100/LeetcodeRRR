//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 642 👎 0


package top.nzhz.leetcode.editor.cn;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean[][] isAccessed;
        private int[][] isHandled;


        public int longestIncreasingPath(int[][] matrix) {
            int res = 0;
            int len = matrix.length, wid = matrix[0].length;
            isAccessed = new boolean[len][wid];
            isHandled = new int[len][wid];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < wid; j++) {
                    res = Math.max(dfs(matrix, i, j), res);
                }
            }
            return res;
        }

        private int dfs(int[][] matrix, int x, int y) {
            if (isHandled[x][y] != 0) return isHandled[x][y];
            isAccessed[x][y] = true;
            int max = 1;
            if (x > 0 && !isAccessed[x - 1][y] && matrix[x - 1][y] > matrix[x][y]) {
                max = Math.max(dfs(matrix, x - 1, y) + 1, max);
            }
            if (y > 0 && !isAccessed[x][y - 1] && matrix[x][y - 1] > matrix[x][y]) {
                max = Math.max(dfs(matrix, x, y - 1) + 1, max);
            }
            if (x < matrix.length - 1 && !isAccessed[x + 1][y] && matrix[x + 1][y] > matrix[x][y]) {
                max = Math.max(dfs(matrix, x + 1, y) + 1, max);
            }
            if (y < matrix[0].length-1 && !isAccessed[x][y + 1] && matrix[x][y + 1] > matrix[x][y]) {
                max = Math.max(dfs(matrix, x, y+1) + 1, max);
            }
            isAccessed[x][y] = false;
            isHandled[x][y] = max;
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}