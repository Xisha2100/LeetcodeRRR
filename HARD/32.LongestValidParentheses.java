//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1529 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        String s = "";
        solution.longestValidParentheses(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //非常巧妙的栈实现 需要多看几次
        public int longestValidParentheses(String s) {
            int max=0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='('){
                    stack.push(i);
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push(i);
                    }else {
                        max=Math.max(max,i-stack.peek());
                    }
                }
            }
            return max;
        }
//        比较容易想到的动态规划
//        public int longestValidParenthesesDP(String s) {
//            int[] dp = new int[s.length()];
//            int max = 0;
//            if (s.length()>1&&s.charAt(1) == ')') {
//                if (s.charAt(0) == '(') {
//                    dp[1] = 2;
//                }
//                max = Math.max(max, dp[1]);
//            }
//
//            for (int i = 2; i < s.length(); i++) {
//                if (s.charAt(i) == ')') {
//                    if (s.charAt(i - 1) == '(') {
//                        dp[i] = dp[i - 2] + 2;
//                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                        if (i - dp[i - 1] >= 2) {
//                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
//                        } else {
//                            dp[i] = dp[i - 1] + 2;
//                        }
//                    }
//                }
//                max = Math.max(max, dp[i]);
//            }
//            return max;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}