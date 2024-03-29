//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1310 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{7,2,4},2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            int[] ans = new int[len - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offer(i);
            }
            ans[0]=nums[deque.peekFirst()];
            for (int i = k; i < len; i++) {
                while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offer(i);
                while (deque.peekFirst()<=i-k){
                    deque.pollFirst();
                }
                ans[i-k+1]=nums[deque.peekFirst()];
            }
            return ans;
        }
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            int len = nums.length;
//            int[] ans = new int[len - k + 1];
//            PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o2[1]-o1[1];
//                }
//            }){{
//                for (int i = 0; i < k; i++) {
//                    add(new int[]{i,nums[i]});
//                }
//            }};
//            ans[0]=queue.peek()[1];
//
//            for (int i = k; i < nums.length; i++) {
//                queue.add(new int[]{i,nums[i]});
//                while (queue.peek()[0]<=i-k){
//                    queue.poll();
//                }
//                ans[i-k+1]=queue.peek()[1];
//            }
//            return ans;
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}