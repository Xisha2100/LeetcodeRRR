  //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 202 👎 0

  
  package top.nzhz.leetcode.editor.cn;
  
  public class TiHuanKongGeLcof{
      public static void main(String[] args) {
           Solution solution = new TiHuanKongGeLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i)==' '){
                sb.replace(i, i+1,"%20");
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }