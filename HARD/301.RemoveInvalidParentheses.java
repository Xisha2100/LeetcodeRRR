//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 642 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        solution.removeInvalidParentheses("))");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> ans = new ArrayList<>();

        public List<String> removeInvalidParentheses(String s) {
            int left = 0, right = 0, num = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else if (s.charAt(i) == ')') {
                    if(left>0){
                        left--;
                    }else {
                        right++;
                    }
                }
            }
            helper(s, 0, left, right);
            return ans;
        }

        private void helper(String str, int start, int left, int right) {
            if (left == 0 && right == 0) {
                if(valid(str))
                ans.add(str);
                return;
            }
            for (int i = start; i < str.length(); i++) {
                if(i!=start&&str.charAt(i)==str.charAt(i-1)){
                    continue;
                }
                if(str.length()-i<left+right) return;
                if(left>0&&str.charAt(i)=='('){
                    helper(str.substring(0,i)+str.substring(i+1),i,left-1,right);
                }
                if (right > 0 && str.charAt(i) == ')') {
                    helper(str.substring(0,i)+str.substring(i+1),i,left,right-1);
                }
            }


        }

        private boolean valid (String str){
            int nums=0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='('){
                    nums++;
                }else if(str.charAt(i)==')'){
                    nums--;
                    if(nums<0) return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}