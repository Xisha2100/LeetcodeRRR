//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 168 👎 0

  
  package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;

public class CongShangDaoXiaDaYinErChaShuLcof{
      public static void main(String[] args) {
           Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        LinkedList<TreeNode> fifo = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        fifo.offerFirst(root);
        int level=1;
        while (!fifo.isEmpty()){
            int curLevel=0;
            for (int i = 0; i < level; i++) {
                TreeNode temp=fifo.removeLast();
                res.add(temp.val);
                if(temp.left!=null){
                    fifo.offerFirst(temp.left);
                    curLevel++;
                }
                if(temp.right!=null){
                    fifo.offerFirst(temp.right);
                    curLevel++;
                }
            }
            level=curLevel;
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }