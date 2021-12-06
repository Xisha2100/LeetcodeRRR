//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1433 👎 0


package top.nzhz.leetcode.editor.cn;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] ans = new int[n+1];
            ans[0]=1;
            for (int i = 1; i < n+1; i++) {
                for (int j = 0; j < i/2; j++) {
                    ans[i]+=2*ans[j]*ans[i-j-1];
                }
                if(i%2==1) {
                    ans[i] += ans[i/2]*ans[i/2];
                }
            }

            return ans[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}