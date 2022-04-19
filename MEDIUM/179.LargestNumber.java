//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 919 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        solution.largestNumber(new int[]{3, 31, 34, 5, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            PriorityQueue<String> str = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
            for (int num : nums) {
                str.add(String.valueOf(num));
            }
            StringBuilder sb = new StringBuilder();
            if (str.peek().equals("0")) return "0";
            while (!str.isEmpty()) {
                sb.append(str.poll());
            }

            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}