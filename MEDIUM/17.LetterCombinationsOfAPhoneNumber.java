//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1593 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        String d = "472";
        List a = solution.letterCombinations(d);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Character, String> phoneMap = new HashMap<>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        private StringBuilder sb = new StringBuilder();

        private List<String> ans = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if(digits.length()==0) return ans;
            backtrack(digits,0);
            return ans;

        }

        private void backtrack(String digits, int index) {
            if (sb.length() == digits.length()) {
                ans.add(sb.toString());
                return;
            }

            for (char ch : phoneMap.get(digits.charAt(index)).toCharArray()) {
                sb.append(ch);
                backtrack(digits, index + 1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        //有趣的方法
//        public List<String> letterCombinations(String digits) {
//            List<String> result = new ArrayList<>();
//            if(digits == null || digits.length() == 0){
//                return result;
//            }
//            String[] strs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//            //1.先算出一共有几种
//            int len = 1;
//            for(int i = 0; i < digits.length(); i++){
//                int c = digits.charAt(i)-'0';
//                len *= strs[c].length();
//            }
//
////再用求余方法拿到每一种
//            for(int i = 0 ; i < len; i++){
//                int last = i;
//                StringBuilder sb = new StringBuilder();
//                for(int j = digits.length()-1; j>=0;j--){
//                    int c = digits.charAt(j)-'0';
//                    int pos = last%strs[c].length();
//                    sb.append(strs[c].charAt(pos));
//                    last = last/strs[c].length();
//                }
//                result.add(sb.reverse().toString());
//            }
//
//
//            return result;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}