//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 873 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            ArrayList<Integer> primes = new ArrayList<>();
            boolean[] isP = new boolean[n];
            for (int i = 2; i < n; i++) {
                if(!isP[i]) primes.add(i);
                for (int j = 0; j < primes.size(); j++) {
                    int temp=primes.get(j);
                    if(i*temp>=n) break;
                    isP[temp*i]=true;
                    if(i%temp==0) break;
                }
            }
            return primes.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}