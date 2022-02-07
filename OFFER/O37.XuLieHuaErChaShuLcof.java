//请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 261 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.LinkedList;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec codec = new XuLieHuaErChaShuLcof().new Codec();
        String temp=codec.serialize(new TreeNode(1,new TreeNode(2),new TreeNode(3,new TreeNode(4),new TreeNode(5))));
        codec.deserialize(temp);

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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "[]";
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.offerFirst(root);
            int levelSize = 1;
            while (true) {
                StringBuilder level = new StringBuilder();
                boolean flag = false;
                int curSize = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode temp = stack.pollLast();
                    if (temp == null) {
                        level.append("#,");
                    } else {
                        flag = true;
                        curSize++;
                        curSize++;
                        level.append(temp.val);
                        level.append(',');
                        stack.offerFirst(temp.left);
                        stack.offerFirst(temp.right);
                    }
                }
                if (!flag) break;
                levelSize = curSize;
                sb.append(level);
            }
            sb.append(']');
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "[]") return null;
            String[] val = data.substring(1, data.length() - 1).split(",");
            TreeNode head = new TreeNode(Integer.parseInt(val[0]));
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.offerFirst(head);
            int levelSize = 1;
            int curLoc = 0;
            while (curLoc<val.length-1) {
                int curSize = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode temp = stack.pollLast();
                    if (!val[++curLoc].equals("#")) {
                        curSize++;
                        temp.left = new TreeNode(Integer.parseInt(val[curLoc]));
                        stack.offerFirst(temp.left);
                    }
                    if (!val[++curLoc].equals("#")) {
                        curSize++;
                        temp.right = new TreeNode(Integer.parseInt(val[curLoc]));
                        stack.offerFirst(temp.right);
                    }
                }
                levelSize=curSize;
            }
            return head;
        }
    }
//    }    public class Codec {
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            if (root == null) return "[]";
//            StringBuilder sb = new StringBuilder();
//            sb.append('[');
//            LinkedList<TreeNode> stack = new LinkedList<>();
//            stack.offerFirst(root);
//            int levelSize = 1;
//            while (!stack.isEmpty()) {
//                StringBuilder level = new StringBuilder();
//                boolean flag = false;
//                for (int i = 0; i < levelSize; i++) {
//                    TreeNode temp = stack.pollLast();
//                    if (temp == null) {
//                        level.append("#,");
//                        stack.offerFirst(null);
//                        stack.offerFirst(null);
//                    } else {
//                        flag = true;
//                        level.append(temp.val);
//                        level.append(',');
//                        stack.offerFirst(temp.left);
//                        stack.offerFirst(temp.right);
//                    }
//                }
//                if(!flag) break;
//                levelSize *= 2;
//                sb.append(level);
//            }
//
//            sb.append(']');
//            return sb.toString();
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            if(data=="[]")return null;
//            String[] val= data.substring(1,data.length()-1).split(",");
//            TreeNode head=new TreeNode(Integer.parseInt(val[0]));
//            LinkedList<TreeNode> stack = new LinkedList<>();
//            stack.offerFirst(head);
//            for (int i = 0; i < val.length/2; i++) {
//                if(val[i].equals("#")) continue;
//                TreeNode temp=stack.pollLast();
//                if(!val[i*2+1].equals("#")){
//                    temp.left=new TreeNode(Integer.parseInt(val[i*2+1]));
//                    stack.offerFirst(temp.left);
//                }
//                if(!val[i*2+2].equals("#")){
//                    temp.right=new TreeNode(Integer.parseInt(val[i*2+2]));
//                    stack.offerFirst(temp.right);
//                }
//            }
//            return head;
////            TreeNode[] stack=new TreeNode[val.length];
////            for (int i = 0; i < val.length; i++) {
////                if(val[i].equals("null")) continue;
////                stack[i]=new TreeNode(Integer.parseInt(val[i]));
////            }
////            for (int i = 0; i < val.length/2; i++) {
////                if (stack[i]==null) continue;
////                stack[i].left=stack[2*i+1];
////                stack[i].right=stack[2*i+2];
////            }
////            return stack[0];
//        }
//    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}