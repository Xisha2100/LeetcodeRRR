//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1644 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.permute(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            boolean[] status = new boolean[nums.length];
            int pathLen = 0;
            dfs(nums, status, path, pathLen, ans);
            return ans;
        }

        private void dfs(int[] nums, boolean[] status, LinkedList<Integer> path, int pathLen, List<List<Integer>> ans) {
            if (pathLen == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!status[i]) {
                    status[i] = true;
                    path.push(nums[i]);
                    pathLen++;
                    dfs(nums, status, path, pathLen, ans);
                    path.pop();
                    pathLen--;
                    status[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}