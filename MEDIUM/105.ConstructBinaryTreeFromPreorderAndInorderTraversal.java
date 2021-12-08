//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1324 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
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
        private int[] preorder;
        private Map<Integer, Integer> inorderMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.inorderMap = new HashMap<>();
            this.preorder = preorder;
//            Map<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

//            return buildTree(preorder, 0, preorder.length - 1,0,inorder.length-1,inorderMap);
            return buildTree(0, preorder.length - 1,0,inorder.length-1);
        }

        //        public TreeNode buildTree(int[] preorder, int Pleft, int Pright, int Ileft, int Iright,Map<Integer, Integer> inorderMap) {
//            if(Pleft==Pright) return new TreeNode(preorder[Pleft]);
//            if(Pleft>=Pright) return null;
//            int splitLoc = inorderMap.get(preorder[Pleft]);
//
//            return new TreeNode(preorder[Pleft],buildTree(preorder,Pleft+1,Pleft+splitLoc-Ileft,Ileft,splitLoc-1,inorderMap),
//                    buildTree(preorder,Pleft+splitLoc-Ileft+1,Pright,splitLoc+1,Iright,inorderMap));
//        }
        public TreeNode buildTree(int Pleft, int Pright, int Ileft, int Iright) {
            if (Pleft == Pright) return new TreeNode(preorder[Pleft]);
            if (Pleft >= Pright) return null;
            int splitLoc = inorderMap.get(preorder[Pleft]);

            return new TreeNode(preorder[Pleft], buildTree( Pleft + 1, Pleft + splitLoc - Ileft, Ileft, splitLoc - 1),
                    buildTree( Pleft + splitLoc - Ileft + 1, Pright, splitLoc + 1, Iright));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}