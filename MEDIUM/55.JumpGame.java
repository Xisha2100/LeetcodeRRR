//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1506 👎 0


package top.nzhz.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int max=0;

            for (int i = 0; i < nums.length; i++) {
                if(i>max) return false;

                max=Math.max(max,nums[i]+i);

                if(max>=nums.length-1){
                    return true;
                }

            }

            return false;

        }


//    public boolean canJump(int[] nums) {
//
//        boolean[] dp = new boolean[nums.length];
//        dp[nums.length-1]=true;
//
//        if(nums.length==1){
//            return dp[0];
//        }
//        for (int i = nums.length-2; i >=0 ; i--) {
//            if (nums[i]+i>=nums.length-1){
//                dp[i]=true;
//            }else {
//                for (int j = 1; j <= nums[i]; j++) {
//                    if(dp[i+j]==true)
//                        dp[i]=true;
//                }
//            }
//        }
//
//        return dp[0];
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}