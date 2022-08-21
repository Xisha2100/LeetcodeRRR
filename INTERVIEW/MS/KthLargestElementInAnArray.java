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
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1522 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(new int[]{1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int findKthLargest(int[] nums, int k) {
//            return Arrays.stream(nums).sorted().limit(nums.length - k + 1).max().getAsInt();
//        }

//        public int findKthLargest(int[] nums, int k) {
//            return quickSelect(nums,k-1,0,nums.length-1);
//        }
//
//        private Random rand=new Random();
//        private int quickSelect(int[] nums, int k, int left, int right){
//            int q=quickSort(nums,left,right);
//            if(q==k) return nums[q];
//            else if(q<k) return quickSelect(nums,k,q+1,right);
//            else return quickSelect(nums,k,left,q-1);
//        }
//
//        private int quickSort(int[] nums, int left, int right){
//            swap(nums,left,left+rand.nextInt(right-left+1));
//            int split=nums[left];
//            while (left<right){
//                while (left<right&&nums[right]<split){
//                    right--;
//                }
//                swap(nums,right,left);
//                while (left<right&&nums[left]>=split){
//                    left++;
//                }
//                swap(nums,right,left);
//            }
//            nums[left]=split;
//            return left;
//        }
//
//        private void swap(int[] nums, int a, int b){
//            int temp=nums[a];
//            nums[a]=nums[b];
//            nums[b]=temp;
//        }


        public int findKthLargest(int[] nums, int k) {
            int[] heap = Arrays.copyOf(nums, k);
            buildMinHeap(heap);
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > heap[0]) {
                    heap[0] = nums[i];
                    adjustHeap(heap, 0);
                }
            }
            return heap[0];
        }

        private void buildMinHeap(int[] heap) {
            for (int i = heap.length / 2; i >= 0; i--) {
                adjustHeap(heap, i);
            }
        }

        private void adjustHeap(int[] heap, int loc) {
            int left = 2 * loc + 1, right = 2 * loc + 2, min = loc;
            if (left < heap.length && heap[left] < heap[min]) {
                min = left;
            }
            if (right < heap.length && heap[right] < heap[min]) {
                min = right;
            }
            if (min != loc) {
                swap(heap, min, loc);
                adjustHeap(heap, min);
            }

        }


        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}