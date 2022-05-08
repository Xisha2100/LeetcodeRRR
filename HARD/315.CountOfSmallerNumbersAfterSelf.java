//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 798 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        solution.countSmaller(new int[]{5,2,6,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private HashMap<Integer, Integer> map;
        private int[] a;
        public List<Integer> countSmaller(int[] nums) {
            map = new HashMap<>();
            for(int num:nums){
                map.put(num,null);
            }
            a = new int[map.size()];
            int loc=0;
            for (int num:map.keySet()){
                a[loc++]=num;
            }
            Arrays.sort(a);
            loc=1;
            for (int num:a){
                map.put(num,loc++);
            }
            LinkedList<Integer> res = new LinkedList<>();
            a=new int[map.size()];
            for (int i=nums.length-1;i>=0;i--){
                int id=map.get(nums[i]);
                int sum=query(id-1);
                res.addFirst(sum);
                update(id);
            }

            return res;
        }

        private int query(int loc){
            int res=0;
            while (loc>0){
                res+=a[loc];
                loc-=lowBit(loc);
            }
            return res;
        }

        private void update(int loc){
            while (loc<a.length){
                a[loc]+=1;
                loc+=lowBit(loc);
            }
        }

        private int lowBit(int x){
            return x&(-x);
        }

//      逆转数对
//        private int[] index;
//        private int[] res;
//        private int[] tempNums;
//        private int[] tempIndex;
//
//        public List<Integer> countSmaller(int[] nums) {
//            this.index = new int[nums.length];
//            this.res = new int[nums.length];
//            this.tempNums = new int[nums.length];
//            this.tempIndex = new int[nums.length];
//
//            for (int i = 0; i < nums.length; i++) {
//                index[i] = i;
//            }
//
//            mergeSort(nums, 0, nums.length - 1);
//
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int num : res) {
//                list.add(num);
//            }
//            return list;
//        }
//
//        private void mergeSort(int[] nums, int left, int right) {
//            if (left >= right) return;
//            int mid = (left + right) >> 1;
//            mergeSort(nums, left, mid);
//            mergeSort(nums, mid + 1, right);
//            merge(nums, left, mid, right);
//        }
//
//        private void merge(int[] nums, int left, int mid, int right) {
//            int curL = left, curR = mid + 1, loc = left;
//            while (curL <= mid && curR <= right) {
//                if (nums[curL] <= nums[curR]) {
//                    tempNums[loc]=nums[curL];
//                    tempIndex[loc]=index[curL];
//                    res[index[curL]]+=curR-mid-1;
//                    curL++;
//                    loc++;
//                } else {
//                    tempNums[loc]=nums[curR];
//                    tempIndex[loc]=index[curR];
//                    curR++;
//                    loc++;
//                }
//            }
//            while (curL<=mid){
//                tempNums[loc]=nums[curL];
//                tempIndex[loc]=index[curL];
//                res[index[curL]]+=curR-mid-1;
//                curL++;
//                loc++;
//            }
//            while (curR <= right){
//                tempNums[loc]=nums[curR];
//                tempIndex[loc]=index[curR];
//                curR++;
//                loc++;
//            }
//            for (int i = left; i <= right; i++) {
//                index[i]=tempIndex[i];
//                nums[i]=tempNums[i];
//            }
//        }

//        public List<Integer> countSmaller(int[] nums) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int i = 0; i < nums.length; i++) {
//                int cnt = 0;
//                for (int j = i + 1; j < nums.length; j++) {
//                    if(nums[i]>nums[j]) cnt++;
//                }
//                list.add(cnt);
//            }
//
//            return list;
//        }
        }
//leetcode submit region end(Prohibit modification and deletion)

    }