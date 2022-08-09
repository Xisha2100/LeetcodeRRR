//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
// Related Topics 贪心 数组 👍 955 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Candy {
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            int len = ratings.length;
            int res = 0;
            int[] left = new int[len];
            left[0] = 1;
            for (int i = 1; i < len; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }
            int right = 1;
            res += Math.max(right, left[len - 1]);
            for (int i = len - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right++;
                } else {
                    right = 1;
                }
                res += Math.max(right, left[i]);
            }
            return res;
        }
//        public int candy(int[] ratings) {
//            int len = ratings.length;
//            if(len==1){
//                return 1;
//            }
//            int[] candy = new int[len];
//            int res=0;
//            Arrays.fill(candy,1);
//            HashMap<Integer, List<Integer>> map = new HashMap<>();
//            for (int i = 0; i < len; i++) {
//                List<Integer> temp = map.getOrDefault(ratings[i], new ArrayList<>());
//                if (temp.isEmpty()) {
//                    map.put(ratings[i], temp);
//                }
//                temp.add(i);
//            }
//            List<Integer> rateList = map.keySet().stream().sorted().collect(Collectors.toList());
//            for (int rate : rateList) {
//                for (int loc:map.get(rate)){
//                    if(loc==0){
//                        if(ratings[loc]>ratings[loc+1]){
//                            candy[loc]=candy[loc+1]+1;
//                        }
//                    }else if(loc==len-1){
//                        if(ratings[loc]>ratings[loc-1]){
//                            candy[loc]=candy[loc-1]+1;
//                        }
//                    }else {
//                        if(ratings[loc]>ratings[loc+1]&&ratings[loc]>ratings[loc-1]){
//                            candy[loc]=Math.max(candy[loc+1],candy[loc-1])+1;
//                        }else if(ratings[loc]>ratings[loc+1]){
//                            candy[loc]=candy[loc+1]+1;
//                        }else if(ratings[loc]>ratings[loc-1]){
//                            candy[loc]=candy[loc-1]+1;
//                        }
//                    }
//                    res+=candy[loc];
//                }
//            }
//            return res;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}