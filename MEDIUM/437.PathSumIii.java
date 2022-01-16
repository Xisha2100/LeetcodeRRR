//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1187 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        solution.pathSum(deserialize("[10,5,-3,3,2,null,11,3,-2,null,1,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,]"),8);


    }

    public static TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 2).split(",");
        if (nodes[0].equals("null")) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offerLast(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pollFirst();
            if (!nodes[index].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offerLast(temp.left);
            }
            index++;
            if (!nodes[index].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offerLast(temp.right);
            }
            index++;
        }

        return root;
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
        private HashMap<Long,Integer> pre;

        public int pathSum(TreeNode root, int targetSum) {
            pre=new HashMap<>();
            pre.put(0L,1);
            return dfs(root,0,targetSum);
        }

        private int dfs(TreeNode root, long cur, int targetSum){
            if(root==null) return 0;

            cur+=root.val;

            int ans=pre.getOrDefault(cur-targetSum,0);
            pre.put(cur,pre.getOrDefault(cur,0)+1);
            ans+=dfs(root.left,cur,targetSum);
            ans+=dfs(root.right,cur,targetSum);

            pre.put(cur,pre.getOrDefault(cur,0)-1);
            return ans;
        }
//        public int pathSum(TreeNode root, int targetSum) {
//            if (root == null) {
//                return 0;
//            }
//
//            int ans =rootSum(root,targetSum);
//            ans+=pathSum(root.left,targetSum);
//            ans+=pathSum(root.right,targetSum);
//
//            return ans;
//        }
//
//        public int rootSum(TreeNode root, int targetSum) {
//            if (root == null) return 0;
//            int ans = 0;
//
//            int val=root.val;
//            if(val==targetSum){
//                ans++;
//            }
//
//            ans+=rootSum(root.left,targetSum-val);
//            ans+=rootSum(root.right,targetSum-val);
//
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}