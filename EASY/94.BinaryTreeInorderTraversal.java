//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1194 👎 0


package top.nzhz.leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

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
//      有趣的颜色标记法。
        class ColorNode{
            TreeNode node;
            boolean isVisted;

            public ColorNode(TreeNode node, boolean isVisted) {
                this.node = node;
                this.isVisted = isVisted;
            }
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root==null) return ans;

            Deque<ColorNode> stack = new ArrayDeque<>();
            stack.push(new ColorNode(root, false));

            while (!stack.isEmpty()){
                ColorNode temp = stack.pop();
                if(!temp.isVisted){
                    if(temp.node.right!=null) stack.push(new ColorNode(temp.node.right,false));
                    stack.push(new ColorNode(temp.node,true));
                    if(temp.node.left!=null) stack.push(new ColorNode(temp.node.left,false));
                }else {
                    ans.add(temp.node.val);
                }
            }
            return ans;
        }

//        方法二：迭代
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> ans = new ArrayList<>();
//            Deque<TreeNode> stack = new ArrayDeque<>();
//            while (root!=null||!stack.isEmpty()){
//                while (root!=null){
//                    stack.push(root);
//                    root=root.left;
//                }
//                root = stack.pop();
//                ans.add(root.val);
//                root=root.right;
//            }
//            return ans;
//        }
//        方法一：迭代
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> ans = new ArrayList<>();
//
//            iter(root,ans);
//
//            return ans;
//        }
//
//        private void iter(TreeNode root, List<Integer> ans) {
//            if (root == null) return;
//            iter(root.left, ans);
//            ans.add(root.val);
//            iter(root.right, ans);
//
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}