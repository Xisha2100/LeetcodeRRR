//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 630 👎 0


package top.nzhz.leetcode.editor.cn;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int res = 0;
        private int[] temp;

        public int reversePairs(int[] nums) {
            int len = nums.length;
            temp = new int[len];
            sort(nums, 0, len - 1);
            return res;
        }

        private void sort(int[] nums, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                sort(nums, left, mid);
                sort(nums, mid + 1, right);
                merge(nums, left, mid, right);
            }
        }

        private void merge(int[] nums, int left, int mid, int right) {
            int i = left;
            int j = mid + 1;
            int t = 0;

            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    temp[t++] = nums[i++];
                } else {
                    res += (mid - i + 1);
                    temp[t++] = nums[j++];
                }
            }


            while (i <= mid) {
                temp[t++] = nums[i++];
            }
            while (j <= right) {
                temp[t++] = nums[j++];
            }

            t = 0;
            while (left <= right) {
                nums[left++] = temp[t++];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}