//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 796 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        solution.findSubstring("aaaaaaaaaaaaaa", new String[]{"aa", "aa"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int wordLen = words[0].length();
            int keySize = words.length;
            int keyLen = wordLen * keySize;
            ArrayList<Integer> res = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < keySize; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
            for (int i = 0; i < wordLen; i++) {
                String splitStrs[] = new String[(s.length() - i) / wordLen];
                if (i + keyLen > s.length()) {
                    break;
                }
                for (int j = 0; j < splitStrs.length; j++) {
                    splitStrs[j] = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                }
                int cnt = 0;
                for (int j = 0; j < keySize; j++) {
                    if (map.containsKey(splitStrs[j])) {
                        int num = map.get(splitStrs[j]);
                        if (num > 0) {
                            cnt++;
                        }
                        map.put(splitStrs[j], num - 1);
                    }
                }
                if (cnt == keySize) {
                    res.add(i);
                }
                for (int j = 0; j < splitStrs.length - keySize; j++) {
                    if (map.containsKey(splitStrs[j])) {
                        int num = map.get(splitStrs[j]);
                        if (num >= 0) {
                            cnt--;
                        }
                        map.put(splitStrs[j], num + 1);
                    }
                    if (map.containsKey(splitStrs[j + keySize])) {
                        int num = map.get(splitStrs[j + keySize]);
                        if (num > 0) {
                            cnt++;
                        }
                        map.put(splitStrs[j + keySize], num - 1);
                    }
                    if (cnt == keySize) {
                        res.add(i + (j + 1) * wordLen);
                    }
                }
                for (int j = splitStrs.length - keySize; j < splitStrs.length; j++) {
                    if (map.containsKey(splitStrs[j])) {
                        int num = map.get(splitStrs[j]);
                        map.put(splitStrs[j], num + 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}