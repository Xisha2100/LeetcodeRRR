//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2869 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        3.栈
        public int trap(int[] height){
            LinkedList<Integer> stack=new LinkedList<>();
            int ans=0;
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                    int bottom=stack.pop();
                    if(stack.isEmpty()) break;
                    int left=stack.peek();
                    int w=i-left-1;
                    int h=Math.min(height[left],height[i])-height[bottom];
                    ans +=w*h;
                }
                stack.push(i);
            }
            return ans;
        }



//        2.方法相同，使用双指针，空间更优
//        public int trap(int[] height) {
//            int l = 0, r = height.length - 1;
//            int leftMax = 0, rightMax = 0;
//            int ans=0;
//            while (l < r) {
//                leftMax = Math.max(leftMax, height[l]);
//                rightMax = Math.max(rightMax,height[r]);
//                if(height[l]<height[r]){
//                    ans+=leftMax-height[l];
//                    l++;
//                }else {
//                    ans+=rightMax-height[r];
//                    r--;
//                }
//            }
//            return ans;
//        }
//

//        1.动态规划，算每一列
//        public int trap(int[] height) {
//            int len = height.length;
//
//            int[] leftMax = new int[len];
//            int[] rightMax = new int[len];
//            leftMax[0] = height[0];
//            rightMax[len - 1] = height[len - 1];
//
//            for (int i = 1; i < len; i++) {
//                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//                rightMax[len - 1 - i] = Math.max(rightMax[len - i], height[len - 1 - i]);
//            }
//
//            int ans = 0;
//            for (int i = 0; i < len; i++) {
//                ans+=Math.min(leftMax[i],rightMax[i])-height[i];
//            }
//
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}