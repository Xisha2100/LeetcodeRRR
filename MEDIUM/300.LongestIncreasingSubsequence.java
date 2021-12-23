//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2097 👎 0


package top.nzhz.leetcode.editor.cn;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int ans=1, len=nums.length;
            int[] d = new int[len + 1];
            d[ans] =nums[0];
            for (int i = 1; i < len; i++) {
                if(nums[i]>d[ans]){
                    ans++;
                    d[ans]=nums[i];
                }else {
                    int l=1,r=ans,pos=0;
                    while (l <= r) {
                        int mid=(l+r)>>1;
                        if(d[mid]<nums[i]){
                            pos=mid;
                            l=mid+1;
                        }else {
                            r=mid-1;
                        }
                    }
                    d[pos+1]=nums[i];
                }

            }
            return ans;
        }
//        public int lengthOfLIS(int[] nums) {
//            int[] cnt = new int[nums.length];
//            int ans=0;
//            for (int i = 0; i < nums.length; i++) {
//                int tempMax = 1;
//                for (int j = 0; j < i; j++) {
//                    if (nums[i] > nums[j]) {
//                        tempMax = Math.max(cnt[j] + 1, tempMax);
//                    }
//                }
//                cnt[i] = tempMax;
//                ans=Math.max(cnt[i],ans);
//            }
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}