//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 913 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = new String[]{
                "fff", "fff", "ab"
        };
        solution.groupAnagrams(strs);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                int[] bucket = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    bucket[s.charAt(i) - 'a']++;
                }
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 26; i++) {
                    if (bucket[i] != 0) {
                        sb.append((char) ('a' + i));
                        sb.append(bucket[i]);
                    }
                }
                String key = sb.toString();

//                String temp = Arrays.toString(bucket);
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(s);
                map.put(key,list);
            }


            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}