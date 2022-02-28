//统计一个数字在排序数组中出现的次数。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 273 👎 0


package top.nzhz.leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length==0) return 0;
            int left = searchL(nums, target);
            int right = searchR(nums, target);

            return right-left+1;
        }

        private int searchL(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=0;
            while (left<right){
                mid=(left+right)/2;
                if(nums[mid]>=target){
                    right=mid;
                }else {
                    left=mid+1;
                }
            }
            return nums[left]==target?left:0;
        }
        private int searchR(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=0;
            while (left<right){
                mid=(left+right+1)/2;
                if(nums[mid]<=target){
                    left=mid;
                }else {
                    right=mid-1;
                }
            }
            return nums[left]==target?left:-1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}