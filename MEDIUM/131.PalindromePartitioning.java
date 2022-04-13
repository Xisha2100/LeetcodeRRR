//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1077 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("efe");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private ArrayList<List<String>> res;
        private ArrayList<String> list;
        boolean[][] isPalindrome;

        public List<List<String>> partition(String s) {
            int len = s.length();
            isPalindrome = new boolean[len][len];
            res = new ArrayList<List<String>>();
            list = new ArrayList<String>();
            if (len == 1) {
                res.add(new ArrayList<>() {{
                    add(s);
                }});
                return res;
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len-i; j++) {
                    if(s.charAt(j)==s.charAt(j+i)&&(i==0||i==1||isPalindrome[j+1][j+i-1]))
                        isPalindrome[j][j+i]=true;
                }
            }
            helper(0, s);
            return res;

        }

        private void helper(int loc, String s) {
            if(loc==s.length()){
                res.add(new ArrayList<>(list));
                return;
            }
            int len = s.length();
            for (int i = loc; i < len; i++) {
                if (isPalindrome[loc][i]) {
                    list.add(s.substring(loc, i + 1));
                    helper(i+1, s);
                    list.remove(list.size()-1);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}