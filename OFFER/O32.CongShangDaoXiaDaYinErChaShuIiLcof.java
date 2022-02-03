//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
// Related Topics 树 广度优先搜索 二叉树 👍 175 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> fifo = new LinkedList<>();
            fifo.offerFirst(root);
            ArrayList<List<Integer>> res = new ArrayList<>();
            int num = 1;
            while (!fifo.isEmpty()) {
                int tempNum = 0;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    TreeNode tempTree = fifo.pollLast();
                    list.add(tempTree.val);
                    if (tempTree.left != null) {
                        fifo.offerFirst(tempTree.left);
                        tempNum++;
                    }
                    if (tempTree.right != null) {
                        fifo.offerFirst(tempTree.right);
                        tempNum++;
                    }
                }
                num=tempNum;
                res.add(list);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}