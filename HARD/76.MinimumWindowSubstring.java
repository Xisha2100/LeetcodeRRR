//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1455 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("A", "AA");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> tMap = new HashMap<>();
            int tlen = t.length(), slen = s.length();
            int num = tlen;
            int l = 0, r = 0;
            int[] scope = {0,Integer.MAX_VALUE};
            boolean flag=false;
            for (int i = 0; i < tlen; i++) {
                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            }
            while (r < slen) {
                if (num > 0) {
                    if (tMap.containsKey(s.charAt(r))) {
                        int temp = tMap.get(s.charAt(r));
                        tMap.put(s.charAt(r), temp - 1);
                        if (temp > 0) {
                            num--;
                        }
                    }
                }
                r++;
                if(num==0){
                    flag=true;
                    while (l <= r - tlen) {
                        if (tMap.containsKey(s.charAt(l))) {
                            int temp = tMap.get(s.charAt(l));
                            tMap.put(s.charAt(l), temp + 1);
                            if (temp == 0) {
                                num++;
                                scope = (r - l) > (scope[1] - scope[0]) ? scope : new int[]{l, r};
                                l++;
                                break;
                            }
                        }
                        l++;
                    }
                }

            }

            return flag?s.substring(scope[0], scope[1]):"";


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}