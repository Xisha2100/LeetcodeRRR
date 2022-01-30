//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 248 👎 0


package top.nzhz.leetcode.editor.cn;

public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if(x==0) return 0;
            if(x==1 || n==0) return 1.0;
            double res=1;
            if(n>0) {
                while (n!=0) {
                    if(n%2==0) {
                        x*=x;
                        n=n/2;
                    }
                    res*=x;
                    n--;
                }
            }else {
                while (n!=0) {
                    if(n%2==0) {
                        x*=x;
                        n=n/2;
                    }
                    res/=x;
                    n++;
                }
            }

            return res;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}