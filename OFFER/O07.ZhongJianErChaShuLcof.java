  //输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
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
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 657 👎 0

  
  package top.nzhz.leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.HashSet;

  public class ZhongJianErChaShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZhongJianErChaShuLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int[] preorder;
    private HashMap<Integer,Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inMap=new HashMap<Integer,Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return buildTreeHelper(0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildTreeHelper(int pSta,int pEnd, int iSta, int iEnd){
        if(pSta>pEnd) return null;
        if(pSta==pEnd) return new TreeNode(preorder[pSta]);

        int loc=inMap.get(preorder[pSta]);
        TreeNode res = new TreeNode(preorder[pSta]);
        res.left=buildTreeHelper(pSta+1,pSta+loc-iSta,iSta,loc-1);
        res.right=buildTreeHelper(pSta+loc-iSta+1,pEnd,loc+1,iEnd);

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }