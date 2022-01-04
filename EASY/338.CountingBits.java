//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
//
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？ 
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ） 
// 
// 
// 
// Related Topics 位运算 动态规划 👍 871 👎 0


package top.nzhz.leetcode.editor.cn;

public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//      题解看来的，性能反而不太行
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <=n ; i++) {
                ans[i]=ans[i&(i-1)]+1;
            }
            return ans;
        }

//        //二倍规律
//        public int[] countBits(int n) {
//            int[] ans = new int[n + 1];
//            for (int i = 1; i <=n ; i++) {
//                ans[i]=ans[i>>1]+(i&1);
//            }
//            return ans;
//        }


//        找规律
//        public int[] countBits(int n) {
//            int[] ans = new int[n + 1];
//            int highBit = 0;
//            for (int i = 1; i <= n; i++) {
//                if ((i & (i - 1)) == 0) {
//                    highBit = i;
//                }
//                ans[i] = ans[i - highBit] + 1;
//            }
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}