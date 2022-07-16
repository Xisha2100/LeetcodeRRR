//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
// Related Topics 队列 哈希表 字符串 计数 👍 572 👎 0


package top.nzhz.leetcode.editor.cn;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            int[] chars = new int[26];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int loc = s.charAt(i) - 'a';
                if (chars[loc] == 0) {
                    chars[loc]++;
                    list.add(i);
                } else if (chars[loc] == 1) {
                    chars[loc]++;
                }
            }
            for (int i : list) {
                if(chars[s.charAt(i)-'a']==1)
                    return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}