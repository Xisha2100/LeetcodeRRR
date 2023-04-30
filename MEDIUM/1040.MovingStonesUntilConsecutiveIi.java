//在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。
//
// 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。 
//
// 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3）
//，该石子都仍然会是端点石子。 
//
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 
//
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, 
//maximum_moves] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,4,9]
//输出：[1,2]
//解释：
//我们可以移动一次，4 -> 8，游戏结束。
//或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
// 
//
// 示例 2： 
//
// 
//输入：[6,5,4,3,10]
//输出：[2,3]
//解释：
//我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
//或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
//注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
// 
//
// 示例 3： 
//
// 
//输入：[100,101,104,102,103]
//输出：[0,0] 
//
// 
//
// 提示： 
//
// 
// 3 <= stones.length <= 10^4 
// 1 <= stones[i] <= 10^9 
// stones[i] 的值各不相同。 
// 
//
// 
// Related Topics 数组 数学 双指针 排序 👍 155 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Arrays;

public class MovingStonesUntilConsecutiveIi {
    public static void main(String[] args) {
        Solution solution = new MovingStonesUntilConsecutiveIi().new Solution();
        solution.numMovesStonesII(new int[]{6,5,4,3,10});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            int len = stones.length;
            int[] arr = stones.clone();
            Arrays.sort(arr);
            if (arr[len - 1] - arr[0] == len - 1) {
                return new int[]{0, 0};
            }
            int max = Math.max(arr[len - 1] - arr[1] - len + 2, arr[len - 2] - arr[0] - len + 2);
            int min = len;
            for (int l = 0, r = 1; l < len && r < len; l++) {
                while (r < len && arr[r] - arr[l] < len) {
                    r++;
                }
                if (r - l == len - 1 && arr[r - 1] - arr[l] == len - 2) {
                    min = Math.min(min, 2);
                } else {
                    min = Math.min(min, len - r + l);
                }
            }
            return new int[]{min, max};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}