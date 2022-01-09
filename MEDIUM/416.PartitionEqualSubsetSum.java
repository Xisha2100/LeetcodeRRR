//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1082 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum=0,max=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                max= Math.max(max,nums[i]);
            }
            if(sum%2==1) return false;

            Arrays.sort(nums);
            int goal=sum/2-nums[nums.length-1];
//            int goal=sum/2;
            if(goal<0) return false;

            boolean[] dp = new boolean[goal+1];
            dp[0]=true;

            for (int i = 0; i < nums.length-1; i++) {
                int num=nums[i];
                for (int j = goal; j >= num; j--) {
                    dp[j]|=dp[j-num];
                }
            }
            return dp[goal];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}