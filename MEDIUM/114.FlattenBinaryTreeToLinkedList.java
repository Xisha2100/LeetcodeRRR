//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
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
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 992 👎 0


package top.nzhz.leetcode.editor.cn;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList fbt = new FlattenBinaryTreeToLinkedList();
        Solution solution = fbt.new Solution();

        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        solution.flatten(test);

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
        //后序遍历
        private TreeNode pre=null;
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.right);
            flatten(root.left);
            root.right=pre;
            root.left=null;
            pre=root;
        }

        //寻找前节点，最好的方法*****
//        public void flatten(TreeNode root) {
//            while (root != null) {
//                if (root.left != null) {
//                    if (root.right != null) {
//                        TreeNode lTree = root.left;
//                        while (lTree.right != null) {
//                            lTree = lTree.right;
//                        }
//                        lTree.right = root.right;
//                    }
//                    root.right = root.left;
//                    root.left = null;
//                }
//                root = root.right;
//            }
//        }
//不太美观的前序
//    public void flatten(TreeNode root) {
//        if(root==null) return;
//        Deque stack = new LinkedList<>();
//        TreeNode head =new TreeNode(0);
//        TreeNode temp=head;
//        TreeNode bk=root;
//        stack.push(root);
//        while (!stack.isEmpty()){
//            if(stack.peek() instanceof Integer){
//
//                temp.right=new TreeNode((int) stack.pop());
//                temp=temp.right;
//                //temp.right=new TreeNode();
//            }else {
//                root = (TreeNode) stack.pop();
//                if(root.right!=null)stack.push(root.right);
//                if(root.left!=null)stack.push(root.left);
//                stack.push(root.val);
//            }
//        }
//        head=head.right;
//        while (head.right!=null){
//            head=head.right;
//            bk.left=null;
//            bk.right=new TreeNode(head.val);
//            bk=bk.right;
//        }
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}