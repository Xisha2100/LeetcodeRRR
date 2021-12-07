//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1054 👎 0

  
package top.nzhz.leetcode.editor.cn;

public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
//    public int maxDepth(TreeNode root) {
//        int ans=0;
//        if(root==null)return ans;
//        Deque<TreeNode> fifo = new LinkedList<>();
//        fifo.add(root);
//
//        while (!fifo.isEmpty()){
//            int levelSize=fifo.size();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode tree = fifo.poll();
//                if(tree.left!=null) fifo.add(tree.left);
//                if(tree.right!=null) fifo.add(tree.right);
//            }
//            ans++;
//        }
//        return ans;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}