//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1105 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int[] heights = new int[matrix[0].length + 2];
            int ans=0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j]=='1')
                        heights[j+1]++;
                    else
                        heights[j+1]=0;
                }
                ans=Math.max(largestRectangleArea(heights),ans);
            }
            return ans;
        }

        private int largestRectangleArea(int[] heights) {

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int ans = 0;

            for (int i = 1; i < heights.length; i++) {

                while (heights[i] < heights[stack.peek()]) {

                    int curH = heights[stack.pop()];
                    int curW = i - stack.peek() - 1;
                    ans = Math.max(ans, curW * curH);
                }
                stack.push(i);
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}