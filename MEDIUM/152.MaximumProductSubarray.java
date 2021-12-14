//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 👍 1400 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int maxDP = nums[0], minDP = nums[0], ans = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int tempMax = maxDP, tempMin = minDP;
                maxDP = Math.max(tempMax * nums[i], Math.max(tempMin * nums[i], nums[i]));
                minDP = Math.min(tempMax * nums[i], Math.min(tempMin * nums[i], nums[i]));
                ans = Math.max(maxDP, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}