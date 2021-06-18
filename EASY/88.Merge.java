package top.nzhz;

import java.lang.reflect.Array;
import java.util.Arrays;

public class merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = Arrays.copyOf(nums1, nums1.length);
        for (int i = 0, j = 0, k = 0; m + n > i; i++) {
            if (m == 0) {
                nums1[i] = nums2[i];
                continue;
            }
            if (n == 0) {
                break;
            }
            if (j == m) {
                nums1[i] = nums2[k];
                k++;
                continue;
            }
            if (k == n) {
                nums1[i] = nums[j];
                j++;
                continue;
            }
            if (nums[j] < nums2[k]) {
                nums1[i] = nums[j];
                j++;
            } else {
                nums1[i] = nums2[k];
                k++;
            }
        }

    }
    //倒序排列，不用额外空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, curP = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[curP] = nums2[p2];
                p2--;
            } else if (p2 == -1) {
                nums1[curP] = nums1[p1];
                p1--;
            } else if (nums1[p1] > nums2[p2]) {
                nums1[curP] = nums1[p1];
                p1--;
            } else {
                nums1[curP] = nums2[p2];
                p2--;
            }
            curP--;
        }

    }
}
