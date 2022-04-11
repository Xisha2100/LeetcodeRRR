//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 613 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        solution.zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            int size = 1;
            LinkedList<TreeNode> deque = new LinkedList<>();
            deque.offerFirst(root);
            boolean flag = false;
            while (!deque.isEmpty()) {
                int levelSize = 0;
                ArrayList<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode temp;
                    if (flag) {
                        temp = deque.removeLast();
                        if (temp.right != null) {
                            deque.offerFirst(temp.right);
                            levelSize++;
                        }
                        if (temp.left != null) {
                            deque.offerFirst(temp.left);
                            levelSize++;
                        }
                    } else {
                        temp = deque.removeFirst();
                        if (temp.left != null) {
                            deque.offerLast(temp.left);
                            levelSize++;
                        }
                        if (temp.right != null) {
                            deque.offerLast(temp.right);
                            levelSize++;
                        }
                    }
                    level.add(temp.val);
                }
                flag=!flag;
                res.add(level);
                size = levelSize;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}