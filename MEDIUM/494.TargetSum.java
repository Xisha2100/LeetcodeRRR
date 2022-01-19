//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1008 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
//            int sum = Arrays.stream(nums).sum();
            int sum=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
            }
            int nTarget = sum - target;
            if (nTarget < 0 || nTarget % 2 != 0) {
                return 0;
            }
            nTarget=nTarget/2;
            int len=nums.length;
            int[] dp=new int[nTarget+1];
            dp[0]=1;
            for (int i = 0; i < len; i++) {
                for (int j = nTarget; j >=nums[i] ; j--) {
                    dp[j]+=dp[j-nums[i]];
                }
            }
                return dp[nTarget];
            }
        }
//        private int ans=0;
//        public int findTargetSumWays(int[] nums, int target) {
//            dfs(nums,0,0,target);
//            return ans;
//        }
//
//        private void dfs(int[] nums,int loc, int sum, int target){
//            if(loc==nums.length){
//                if(sum==target) ans++;
//                return;
//            }
//            dfs(nums,loc+1,sum-nums[loc],target);
//            dfs(nums,loc+1,sum+nums[loc],target);
//        }
//
//    }
//leetcode submit region end(Prohibit modification and deletion)

    }