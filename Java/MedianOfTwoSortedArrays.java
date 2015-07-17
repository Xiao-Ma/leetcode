/**
 * @author Xiao
 * LeetCode: Median of Two Sorted Arrays
 * Description: There are two sorted arrays nums1 and nums2 of size m and n 
 *              respectively. Find the median of the two sorted arrays. The 
 *              overall run time complexity should be O(log (m+n)).
 * Idea: easier way is to find kth smallest, where k = (m+n)/2, and every time
 *       compares nums1[k/2] and nums2[k/2].
 */
 
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if nums1 and nums2 are not null
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 0) {
            return Integer.MIN_VALUE;
        } else if (len1 == 0) {
            if (len2 % 2 == 1) {
                return nums2[len2 / 2];
            } else {
                return (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2.0;
            }
        } else if (len2 == 0) {
            if (len1 % 2 == 1) {
                return nums1[len1 / 2];
            } else {
                return (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2.0;
            }
        }
        if ((len1 + len2) % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, (len1 + len2) / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, (len1 + len2) / 2)
            + findKth(nums1, 0, nums2, 0, (len1 + len2) / 2 + 1)) / 2.0;
        }
    }
    private int findKth(int[] nums1, start1, int[] nums2, start2, k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i, j;
        if (start1 + k / 2 - 1 < nums1.length) {
            i = nums1[start1 + k / 2 - 1];
        } else {
            i = Integer.MAX_VALUE;
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            j = nums2[start2 + k / 2 - 1];
        } else {
            j = Integer.MAX_VALUE;
        }
        if (i > j) {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        } else {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
    }
}