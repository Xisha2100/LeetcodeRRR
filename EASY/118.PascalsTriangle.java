//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 734 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>() {{
                add(1);
            }});
            if (numRows == 1) return res;
            res.add(new ArrayList<>() {{
                add(1);
                add(1);
            }});
            if (numRows == 2) return res;
            for (int i = 2; i < numRows; i++) {
                ArrayList<Integer> curLevel = new ArrayList<>();
                List<Integer> preLevel = res.get(i-1);
                curLevel.add(1);

                for (int j = 1; j <i ; j++) {
                    curLevel.add(preLevel.get(j-1)+preLevel.get(j));
                }
                curLevel.add(1);
                res.add(curLevel);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}