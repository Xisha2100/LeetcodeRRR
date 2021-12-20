//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1411 👎 0


package top.nzhz.leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //建小端堆
        public int findKthLargest(int[] nums, int k) {
            buildMinHeap(nums,k);
            for (int i = k; i < nums.length; i++) {
                if(nums[i]>nums[0]){
                    swap(nums,0,i);
                    minHeapify(nums,0,k);
                }
            }
            return nums[0];
        }

        private void buildMinHeap(int[] nums,int k) {
            for (int i = k / 2 - 1; i >= 0; i--) {
                minHeapify(nums, i, k);
            }
        }

        private void minHeapify(int[] nums, int root, int length) {
            int left = root * 2 + 1, right = left + 1;
            int tempMIn = root;
            if (left < length && nums[left] < nums[tempMIn]) {
                tempMIn = left;
            }
            if (right < length && nums[right] < nums[tempMIn]) {
                tempMIn = right;
            }
            if (tempMIn != root) {
                swap(nums, tempMIn, root);
                minHeapify(nums, tempMIn, length);
            }
        }
        //建大端堆
//        public int findKthLargest(int[] nums, int k) {
//            buildHeap(nums);
//            int iterLen = nums.length;
//            for (int i = 0; i < k-1; i++) {
//                swap(nums,0,--iterLen);
//                maxHeapify(nums,0,iterLen);
//            }
//            return nums[0];
//        }
//
//        private void buildHeap(int[] nums){
//            for (int i = nums.length/2-1; i >=0 ; i--) {
//                maxHeapify(nums,i,nums.length);
//            }
//        }
//
//        private void maxHeapify(int[] nums,int root,int length){
//            int left = root*2+1,right=left+1;
//            int tempMax=root;
//            if(left<length&&nums[left]>nums[tempMax]){
//                tempMax=left;
//            }
//            if(right<length&&nums[right]>nums[tempMax]){
//                tempMax=right;
//            }
//            if(tempMax!=root){
//                swap(nums,tempMax,root);
//                maxHeapify(nums, tempMax, length);
//            }
//        }

        //快排修改
//        public  int findKthLargest(int[] nums, int k) {
//            return QSModified(nums,0, nums.length-1,k);
//        }
//
//        private int QSModified(int[] nums, int left, int right,int k){
//            int rand = (int) (Math.random() * (right - left) + left);
//            swap(nums,left,rand);
//            int x = nums[left];
//            int i=left,j=right;
//            while (i<j){
//                while (nums[j]<=x&&i<j){
//                    j--;
//                }
//                swap(nums,i,j);
//                while (nums[i]>=x&&i<j){
//                    i++;
//                }
//                swap(nums,i,j);
//            }
//            if(i==k-1) return nums[k-1];
//            if(i<k) return QSModified(nums,i+1,right,k);
//            else return QSModified(nums,left,i-1,k);
//        }
//        //快排
//        public int findKthLargest(int[] nums, int k) {
//            QSRand(nums,0,nums.length-1);
//            return nums[k-1];
//        }
//
//        private void QSRand(int[] nums, int left, int right) {
//            if(left>=right) return;
//            int rand = (int) (Math.random() * (right - left) + left);
//            swap(nums,left,rand);
//            int x=nums[left];
//            int i=left,j=right;
//            while (i<j){
//                while (nums[j]<=x&&i<j){
//                    j--;
//                }
//                swap(nums,i,j);
//                while (nums[i]>=x&&i<j){
//                    i++;
//                }
//                swap(nums,i,j);
//            }
//
//            QSRand(nums,left,i-1);
//            QSRand(nums,i+1,right);
//
//        }
//
        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}