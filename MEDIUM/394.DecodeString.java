//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 👍 984 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.LinkedList;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            int num = 0;
            StringBuilder ans = new StringBuilder();
            LinkedList<StringBuilder> strList = new LinkedList<>();
            LinkedList<Integer> numList = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0) {
                    num = num * 10 + s.charAt(i) - '0';
                } else if (s.charAt(i) == '[') {
                    numList.push(num);
                    num = 0;
                    strList.push(ans);
                    ans = new StringBuilder();
                } else if (s.charAt(i) == ']') {
                    int loop = numList.pop();
                    StringBuilder pre = null;
                    if (strList.isEmpty()) {
                        pre = new StringBuilder();
                    } else {
                        pre = strList.pop();
                    }
                    for (int j = 0; j < loop; j++) {
                        pre = pre.append(ans);
                    }
                    ans = pre;
                } else {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}