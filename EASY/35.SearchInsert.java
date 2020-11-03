package top.nzhz;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int left = 0, right = size - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (right == left && target > nums[left]) left++;
        return left;
    }
}
