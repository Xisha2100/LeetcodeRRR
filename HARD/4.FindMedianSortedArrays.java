package top.nzhz;


import java.util.Arrays;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, k=0;
        int[] ans = new int[Math.max(nums1.length, nums2.length)];
        if ((nums1.length + nums2.length) % 2 == 1) {
            while (2 * (i + k) < nums1.length + nums2.length) {
                if (nums1[i] < nums2[k]) {
                    ans[i + k] = nums1[i];
                    i++;
                } else {
                    ans[i + k] = nums2[k];
                    k++;
                }
            }
            System.out.println(Arrays.toString(ans));
            return ans[i+k-1];

        } else {
            while (2 * (i + k) < nums1.length + nums2.length+3) {
                if (nums1[i] < nums2[k]) {
                    ans[i + k] = nums1[i];
                    i++;
                } else {
                    ans[i + k] = nums2[k];
                    k++;
                }
            }
            return (ans[i+k-1]+ans[i+k-2])/2.0;
        }
    }
}
