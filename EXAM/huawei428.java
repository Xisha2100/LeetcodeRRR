package top.nzhz;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        TreeNode test1=new TreeNode(3,new TreeNode(1),new TreeNode(-1));
        TreeNode test2=new TreeNode(-1,new TreeNode(2),test1);
        System.out.println(solution.findMaxSubTree(test2));
    }

    class Solution{
        private int res=Integer.MIN_VALUE;//当前最大子树，搜索完成即为结果;

        public int findMaxSubTree(TreeNode root){
            findMaxEdge(root);
            return res;
        }

//        private void dfs(TreeNode root){
//
//        }

        private int findMaxEdge(TreeNode root){
            if(root==null)return 0;
            int left=findMaxEdge(root.left);
            int right=findMaxEdge(root.right);

            res=Math.max(res,Math.max(right+root.val,Math.max(left+root.val,Math.max(root.val,left+right+root.val))));
            int temp=Math.max(right,left)+ root.val;
            return Math.max(temp, 0);
        }
    }

}
