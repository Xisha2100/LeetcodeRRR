  //给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 365 👎 0

  
  package top.nzhz.leetcode.editor.cn;
  
  public class BaShuZiFanYiChengZiFuChuanLcof{
      public static void main(String[] args) {
           Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        int res=1,p=0,q=1;
        String str=String.valueOf(num);
        for (int i = 1; i < str.length(); i++) {
            p=q;
            q=res;
            if(str.charAt(i-1)=='1'||(str.charAt(i-1)=='2'&&str.charAt(i)<='5'))
                res+=p;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }