//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 二叉树 👍 173 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
            LinkedList<TreeNode> filo = new LinkedList<>();
            filo.offerFirst(root);
            ArrayList<List<Integer>> res = new ArrayList<>();
            int num = 1;
            boolean SDFlag = true;
            while (!filo.isEmpty()) {
                int tempNum = 0;
                ArrayList<Integer> list = new ArrayList<>();
                if (SDFlag) {
                    for (int i = 0; i < num; i++) {
                        TreeNode tempTree = filo.pollLast();
                        list.add(tempTree.val);
                        if (tempTree.left != null) {
                            filo.offerFirst(tempTree.left);
                            tempNum++;
                        }
                        if (tempTree.right != null) {
                            filo.offerFirst(tempTree.right);
                            tempNum++;
                        }
                    }
                }else {
                    for (int i = 0; i < num; i++) {
                        TreeNode tempTree = filo.pollFirst();
                        if (tempTree.right != null) {
                            filo.offerLast(tempTree.right);
                            tempNum++;
                        }
                        if (tempTree.left != null) {
                            filo.offerLast(tempTree.left);
                            tempNum++;
                        }
                        list.add(tempTree.val);
                    }
                }
                SDFlag=!SDFlag;
                num = tempNum;
                res.add(list);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}