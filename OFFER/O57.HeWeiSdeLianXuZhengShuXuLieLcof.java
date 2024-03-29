//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 384 👎 0

  
  package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;

public class HeWeiSdeLianXuZhengShuXuLieLcof{
      public static void main(String[] args) {
           Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        int l=1,r=2;
        while (l<r){
            int sum=(l+r)*(r-l+1)/2;
            if(sum==target){
                int[] temp=new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    temp[i-l]=i;
                }
                res.add(temp);
                l++;
            }else if(sum<target){
                r++;
            }else {
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }