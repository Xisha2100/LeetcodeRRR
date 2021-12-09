//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 994 👎 0

  
package top.nzhz.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //有趣的并查集
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;

            // 首次遍历，与邻居结盟
            UnionFind uf = new UnionFind(nums);
            for (int v : nums)
                uf.union(v, v + 1); // uf.union() 结盟

            // 二次遍历，记录领队距离
            int max = 1;
            for (int v : nums)
                max = Math.max(max, uf.find(v) - v + 1); // uf.find() 查找领队
            return max;
        }
        class UnionFind {
            private int count;
            private Map<Integer, Integer> parent; // (curr, leader)

            UnionFind(int[] arr) {
                parent = new HashMap<>();
                for (int v : arr)
                    parent.put(v, v); // 初始时，各自为战，自己是自己的领队

                count = parent.size(); // 而非 arr.length，因可能存在同 key 的情况
                // 感谢 [@icdd](/u/icdd/) 同学的指正
            }

            // 结盟
            void union(int p, int q) {
                // 不只是 p 与 q 结盟，而是整个 p 所在队伍 与 q 所在队伍结盟
                // 结盟需各领队出面，而不是小弟出面
                Integer rootP = find(p), rootQ = find(q);
                if (rootP == rootQ) return;
                if (rootP == null || rootQ == null) return;

                // 结盟
                parent.put(rootP, rootQ); // 谁大听谁
                // 应取 max，而本题已明确 p < q 才可这么写
                // 当前写法有损封装性，算法题可不纠结

                count--;
            }

            // 查找领队
            Integer find(int p) {
                if (!parent.containsKey(p))
                    return null;

                // 递归向上找领队
                int root = p;
                while (root != parent.get(root))
                    root = parent.get(root);

                // 路径压缩：扁平化管理，避免日后找领队层级过深
                while (p != parent.get(p)) {
                    int curr = p;
                    p = parent.get(p);
                    parent.put(curr, root);
                }

                return root;
            }
        }


        //常规解法
//    public int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet(){{
//            for (int i = 0; i < nums.length; i++) {
//                add(nums[i]);
//            }
//        }};
//
//        int ans=0;
//        for (int n:set) {
//            if(set.contains(n-1)) continue;
//            int curLen=1;
//            while (set.contains(n+1)){
//                curLen++;
//                n++;
//            }
//            ans= Math.max(curLen,ans);
//            if(ans>set.size()/2) break;
//        }
//        return ans;
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}