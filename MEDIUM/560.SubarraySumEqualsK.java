//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1273 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans=0,pre=0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);
            for (int i = 0; i < nums.length; i++) {
                pre+=nums[i];
                if(map.containsKey(pre-k)){
                    ans+=map.get(pre-k);
                }
                map.put(pre,map.getOrDefault(pre,0)+1);
            }
            return ans;
        }
//        public int subarraySum(int[] nums, int k) {
//            int ans = 0;
//            int[] dp = new int[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = 0; j <= i; j++) {
//                    dp[j] += nums[i];
//                    if (dp[j] - k == 0) ans++;
//                }
//            }
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}