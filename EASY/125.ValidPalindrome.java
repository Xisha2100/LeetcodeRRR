//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 512 👎 0


package top.nzhz.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int left=0,right=s.length()-1;
            s=s.toLowerCase();
            while (left<right){
                while (left<right&&(!isChar(s.charAt(left)))) left++;
                while (left<right&&(!isChar(s.charAt(right)))) right--;
                if(s.charAt(left)!=s.charAt(right)) return false;
                left++;
                right--;
            }

            return true;
        }

        public boolean isChar(char c){
            return (c <= 'z' && c >= 'a') || (c <= '9' && c >= '0');
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}