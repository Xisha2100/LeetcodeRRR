//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= numerator, denominator <= 2³¹ - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 👍 376 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        solution.fractionToDecimal(-1,-2147483648);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if(numerator==0) return "0";
            long num=numerator;
            long den=denominator;
            boolean isMinus=false;
            if(num<0){
                num=-num;
                isMinus=true;
            }
            if(den<0){
                den=-den;
                isMinus=!isMinus;
            }
            StringBuilder res = new StringBuilder();
            if(isMinus) res.append('-');
            if(num>=den){
                res.append(num/den);
                num=num%den;
                num*=10;
            }else if(num<den){
                res.append('0');
                num*=10;
            }
            if(num==0) return res.toString();
            res.append('.');
            ArrayList<Long> list = new ArrayList<>();
            ArrayList<Long> dotNum = new ArrayList<>();
            while (num!=0&&!list.contains(num)){
                list.add(num);
                if(num>=den){
                    dotNum.add(num/den);
                    num=num%den;
                    num*=10;
                }else if(num<den){
                    num*=10;
                    dotNum.add(0L);
                }
            }
            if(num==0){
                for (Long integer : dotNum) {
                    res.append(integer);
                }
            }else {
                for (Long integer : dotNum) {
                    if(list.remove(0)==num){
                        res.append('(');
                    }
                    res.append(integer);
                }
                res.append(')');
            }
            return res.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}