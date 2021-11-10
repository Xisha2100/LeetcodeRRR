//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3951 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{1,-1,-1,0};
        List<List<Integer>> ans = solution.threeSum(nums);

        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //好方法，外循环内双指针
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();

            if (nums.length < 3) {
                return ans;
            }

            Arrays.sort(nums);

            for (int basic = 0; basic < nums.length - 2; basic++) {
                if (nums[basic] > 0) break;
                if (basic > 0 && nums[basic] == nums[basic - 1]) continue;

                int left = basic + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[basic] + nums[left] + nums[right] == 0) {
                        ans.add(Arrays.asList(nums[basic], nums[left], nums[right]));
                        while (right > left&& nums[left] == nums[left + 1] ) {
                            left++;
                        }
                        while ( right > left&&nums[right] == nums[right - 1] ) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if(nums[left]+nums[right]+nums[basic]<0){
                        left++;
                    }else {
                        right--;
                    }

                }
            }
            return ans;
        }

        //坏方法 外双指针内循环
//        public List<List<Integer>> threeSum(int[] nums) {
//            List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//            if (nums.length < 3)
//                return ans;
//
//            int left = 0, right = nums.length - 1;
//            int tempSum = 0;
//            Arrays.sort(nums);
//
//
//            while (left < right) {
//                tempSum = nums[left] + nums[right];
//                for (int i = left + 1; i < right; i++) {
//                    if (tempSum + nums[i] == 0) {
//                        List<Integer> singleList = new ArrayList<Integer>();
//                        singleList.add(nums[left]);
//                        singleList.add(nums[i]);
//                        singleList.add(nums[right]);
//                        ans.add(singleList);
//                        break;
//                    }
//                }
//                if (tempSum > 0) {
//                    while (nums[right] == nums[right - 1] && right > left + 1) {
//                        right--;
//                    }
//                    right--;
//                } else if (tempSum < 0) {
//                    while (nums[left] == nums[left + 1] && right > left + 1) {
//                        left++;
//                    }
//                    left++;
//                } else {
//                    //相等情况难以解决，换思路
//                    while (nums[right] == nums[right - 1] && right > left + 1) {
//                        right--;
//                    }
//                    while (nums[left] == nums[left + 1] && right > left + 1) {
//                        left++;
//                    }
//                    if (right - left > 3) {
//                        ans.addAll(threeSum(Arrays.copyOfRange(nums, left, right - 1)));
//                        ans.addAll(threeSum(Arrays.copyOfRange(nums, left + 1, right)));
//                    }
//                }
//            }
//            HashSet set =new HashSet(ans);
//            ans.clear();
//            ans.addAll(set);
//            return ans;
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}