//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 708 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        solution.longestSubstring("aaabb", 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int longestSubstring(String s, int k) {
//            int res = 0;
//            int len = s.length();
//            if (k == 1) {
//                return len;
//            }
//            int[] cnt = new int[26];
//            int num=0;
//            for (int i = 0; i < len; i++) {
//                if(cnt[s.charAt(i)-'a']==0){
//                    cnt[s.charAt(i)-'a']++;
//                    num++;
//                }
//            }
//            for (int t = 1; t <= num; t++) {
//                int left = 0, right = 0;
//                cnt = new int[26];
//                int tot = 0;
//                int less = 0;
//                while (right < len) {
//                    while (tot <= t && right < len) {
//                        if (cnt[s.charAt(right) - 'a'] == k - 1) {
//                            less--;
//                        }
//                        if (cnt[s.charAt(right) - 'a'] == 0) {
//                            tot++;
//                            less++;
//                        }
//                        cnt[s.charAt(right) - 'a']++;
//                        right++;
//                        if (tot == t && less == 0) {
//                            res = Math.max(right - left, res);
//                        }
//                    }
//                    while (tot > t && left < right) {
//                        if (cnt[s.charAt(left) - 'a'] == k) {
//                            less++;
//                        }
//                        if (cnt[s.charAt(left) - 'a'] == 1) {
//                            less--;
//                            tot--;
//                        }
//                        cnt[s.charAt(left) - 'a']--;
//                        left++;
//                        if (tot == t && less == 0) {
//                            res = Math.max(right - left, res);
//                        }
//                    }
//                }
//            }
//            return res;
//        }
        public int res = 0;

        public int longestSubstring(String s, int k) {
            dfs(s, k);
            return res;
        }

        private void dfs(String s, int k) {
            boolean flag = false;
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0 && cnt[i] < k) {
                    flag = true;
                }
            }
            if (!flag) {
                this.res = Math.max(s.length(), this.res);
                return;
            }
            int pre = 0;
            for (int i = 0; i < s.length(); i++) {
                if (cnt[s.charAt(i) - 'a'] < k) {
                    if (pre != i) {
                        dfs(s.substring(pre, i), k);
                    }
                    pre = i + 1;
                }
            }
            if (pre != s.length()) {
                dfs(s.substring(pre), k);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}