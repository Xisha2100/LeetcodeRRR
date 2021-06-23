package top.nzhz;


import java.util.Arrays;

public class FindMedianSortedArrays {
    //暴力求解
    public double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int i = 0, k = 0;
        int[] ans = new int[Math.max(nums1.length, nums2.length) + 1];
        if ((nums1.length + nums2.length) % 2 == 1) {
            while (2 * (i + k) < nums1.length + nums2.length) {
                if (i == nums1.length) {
                    ans[i + k] = nums2[k];
                    k++;
                } else if (k == nums2.length) {
                    ans[i + k] = nums1[i];
                    i++;
                } else {
                    if (nums1[i] < nums2[k]) {
                        ans[i + k] = nums1[i];
                        i++;
                    } else {
                        ans[i + k] = nums2[k];
                        k++;
                    }
                }
            }
            System.out.println(Arrays.toString(ans));
            return ans[i + k - 1];
        } else {
            while (2 * (i + k) < nums1.length + nums2.length + 1) {
                if (i == nums1.length) {
                    ans[i + k] = nums2[k];
                    k++;
                } else if (k == nums2.length) {
                    ans[i + k] = nums1[i];
                    i++;
                } else {
                    if (nums1[i] < nums2[k]) {
                        ans[i + k] = nums1[i];
                        i++;
                    } else {
                        ans[i + k] = nums2[k];
                        k++;
                    }
                }
            }
            return (ans[i + k - 1] + ans[i + k - 2]) / 2.0;
        }
    }

    //Log(M+N)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) {
            return getKthNum(nums1, nums2, (nums1.length + nums2.length) / 2);
        } else {
            return (getKthNum(nums1, nums2, (nums1.length + nums2.length) / 2 - 1)
                    + getKthNum(nums1, nums2, (nums1.length + nums2.length) / 2)) / 2;
        }
    }

    private double getKthNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == length1)
                return nums2[index2 + k];
            if (index2 == length2)
                return nums1[index1 + k];
            if (k == 0)
                return Math.min(nums1[index1], nums2[index2]);

            int half = (k+1) / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1+1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2+1);
                index2 = newIndex2 + 1;
            }

        }
    }
}
