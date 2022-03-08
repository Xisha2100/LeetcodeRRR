//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 397 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.LinkedList;

public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length==0||nums.length==1) return nums;
            LinkedList<Integer> list = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            int loc = 0;
            list.addLast(nums[0]);
            for (int i = 1; i < k; i++) {
                while (list.size() > 0 && list.getLast() < nums[i]) {
                    list.removeLast();
                }
                list.addLast(nums[i]);
            }
            res[loc] = list.getFirst();
            loc++;
            for (int i = k; i < nums.length; i++) {
                if(list.getFirst()==nums[i-k])list.removeFirst();
                while (list.size() > 0 && list.getLast() < nums[i]) {
                    list.removeLast();
                }
                list.addLast(nums[i]);
                res[loc]=list.getFirst();
                loc++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}