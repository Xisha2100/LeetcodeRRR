//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1643 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        Solution solution = st.new Solution();
        solution.isSymmetric(st.new TreeNode(1,
                st.new TreeNode(2,st.new TreeNode(3),st.new TreeNode(4))
                ,st.new TreeNode(2,st.new TreeNode(4),st.new TreeNode(3))));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Deque<TreeNode> stackL = new LinkedList<>();
            Deque<TreeNode> stackR = new LinkedList<>();

            stackL.push(root.left);
            stackR.push(root.right);

            while (!stackL.isEmpty()) {
                TreeNode tempL = stackL.pop();
                TreeNode tempR = stackR.pop();

                if (tempR == null && tempL == null) {
                    continue;
                }
                if (tempR == null || tempL == null) return false;

                if (tempR.val != tempL.val) return false;
                stackL.push(tempL.left);
                stackR.push(tempR.right);
                stackL.push(tempL.right);
                stackR.push(tempR.left);
            }

            return true;

        }
//        public boolean isSymmetric(TreeNode root) {
//
//            return dfs(root.left,root.right);
//
//        }
//
//        private boolean dfs(TreeNode l , TreeNode r){
//            if(l==null&&r!=null) return false;
//            if(l!=null&&r==null) return false;
//            if(l==null&&r==null) return true;
//            if(l.val!=r.val) return false;
//            if(dfs(l.left,r.right)&&dfs(l.right,r.left)) return true;
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}