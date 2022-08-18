//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 哈希表 👍 107 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.HashMap;

public class MaximumEqualFrequency {
    public static void main(String[] args) {
        Solution solution = new MaximumEqualFrequency().new Solution();
        solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualFreq(int[] nums) {
            int res = 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] cnts = new int[nums.length + 1];
            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int cnt = map.getOrDefault(num, 0);
                if (cnt != 0) {
                    cnts[cnt]--;
                }
                cnt++;
                cnts[cnt]++;
                map.put(num, cnt);
                max = Math.max(max, cnt);
                if (cnts[1] == i + 1 || cnts[1] == i - 1) {
                    res = i + 1;
                } else if (cnts[1] == 1) {
                    if (cnts[max] * max == i) {
                        res = i + 1;
                    }
                } else if (cnts[1] == 0) {
                    if (max == i + 1 || (cnts[max] + cnts[max - 1] * (max - 1) == i + 1 && cnts[max] == 1)) {
                        res = i + 1;
                    }
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}