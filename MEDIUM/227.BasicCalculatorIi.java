//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// Related Topics 栈 数学 字符串 👍 557 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.LinkedList;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        solution.calculate("3+5/2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            s = s + "+";
            int[] nums = new int[3];
            boolean preStatus = true;
            boolean hStatus = true;
            boolean flag = false;
            for (int loc = 0; loc < s.length(); loc++) {
                char cur = s.charAt(loc);
                if (Character.isSpaceChar(cur)) continue;
                if (Character.isDigit(cur)) {
                    nums[1] = nums[1] * 10 + (s.charAt(loc) - '0');
                } else {
                    if (flag) {
                        nums[1] = hStatus ? nums[2] * nums[1] : nums[2] / nums[1];
                        flag = false;
                    }
                    if (cur == '+') {
                        nums[0] = preStatus ? nums[0] + nums[1] : nums[0] - nums[1];
                        preStatus = true;
                        nums[1] = 0;
                    } else if (cur == '-') {
                        nums[0] = preStatus ? nums[0] + nums[1] : nums[0] - nums[1];
                        preStatus = false;
                        nums[1] = 0;
                    } else if (cur == '*') {
                        flag = true;
                        nums[2] = nums[1];
                        nums[1] = 0;
                        hStatus = true;
                    } else if (cur == '/') {
                        flag = true;
                        nums[2] = nums[1];
                        nums[1] = 0;
                        hStatus = false;
                    }
                }

            }
            return nums[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}