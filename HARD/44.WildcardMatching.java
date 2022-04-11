//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 👍 840 👎 0


package top.nzhz.leetcode.editor.cn;

public class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
        System.out.println(solution.isMatch("c", "*?*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            if(p.equals("")) return p.equals(s);
            String[] split = p.split("\\*");

            int splitSize = 0;
            for (int i = 0; i < split.length; i++) {
                splitSize += split[i].length();
            }
            int starcnt=p.length()-splitSize;
            if (splitSize > s.length()) return false;
            int left = 0, right = s.length() - 1;
            int sl = 0, sr = split.length - 1;
            if (p.charAt(0) != '*') {
                if (!matches(s, 0, split[sl])) return false;
                left += split[sl].length();
                splitSize -= split[sl].length();
                sl++;
            }
            if (sl > sr){
                if(starcnt==0&&p.length()!=s.length()) return false;
                return true;
            }
            if (splitSize > right - left+1) return false;
            if (p.charAt(p.length() - 1) != '*') {
                if (!matches(s, s.length() - split[sr].length(), split[sr]))
                    return false;
                right -= split[sr].length();
                splitSize -= split[sr].length();
                sr--;
            }

            if (sl > sr) return true;
            if (splitSize > right - left+1) return false;

            while (sl <= sr&&left<=right) {
                if (!matches(s, left, split[sl])) {
                    left++;
                } else {
                    splitSize -= split[sl].length();
                    left+=split[sl].length();
                    sl++;

                }

                if (splitSize > right - left+1) return false;
            }
            return true;

        }

        private boolean matches(String s, int start, String p) {
            for (int i = 0; i < p.length(); i++) {
                if (s.charAt(i + start) == p.charAt(i) || p.charAt(i) == '?') {
                } else return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}