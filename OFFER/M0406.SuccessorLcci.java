//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 188 👎 0


package top.nzhz.leetcode.editor.cn;

public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private TreeNode res=null;
        private int status=0;
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            dfs(root,p);
            return res;
        }

        private void dfs(TreeNode root , TreeNode p){
            if(root==null) return;
            if(status==2) return;
            dfs(root.left,p);
            if(root==p){
                status++;

            }else if(status==1){
                res=root;
                status++;
                return;
            }
            dfs(root.right,p);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}