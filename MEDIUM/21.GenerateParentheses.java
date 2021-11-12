//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2144 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
//        System.out.println(solution.generateParenthesis(3));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划
        public List<String> generateParenthesisDP(int n) {
            //List<String> ansSet = new ArrayList<>();
            List<List<String>> ansSet = new ArrayList<>();
            ansSet.add(new ArrayList<>() {{
                add("");
            }});
//            ansSet.add(new ArrayList<>() {{
//                add("()");
//            }});

            for (int i = 1; i <= n; i++) {
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    List<String> strL = ansSet.get(j);
                    List<String> strR = ansSet.get(i - j - 1);
                    for (String sL : strL) {
                        for (String sR : strR) {
                            temp.add('('+sL+')'+sR);
                        }
                    }
                }
                ansSet.add(temp);
            }

            return ansSet.get(n);
        }


        //深度优先搜索
//        public List<String> generateParenthesisDFS(int n) {
//            List<String> ans = new ArrayList<>();
//            dfs("",n,n,ans);
//            return ans;
//        }
//
//        private void dfs(String curS,int left, int right,List<String>ans){
//            if(left==0&&right==0){
//                ans.add(curS);
//                return;
//            }
//
//            if(left>right) return;
//
//            if(left>0){
//                dfs(curS+'(',left-1,right,ans);
//            }
//            if(right>0){
//                dfs(curS+')',left,right-1,ans);
//            }
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}