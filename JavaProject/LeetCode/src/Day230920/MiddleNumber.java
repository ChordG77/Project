package Day230920;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */

public class MiddleNumber {
    public static final int[] nums1 = {1, 3};
    public static final int[] nums2 = {2};

    public static final int[] nums3 = {1, 3, 5, 7, 9};
    public static final int[] nums4 = {2, 8, 10, 12, 14};

    public static final int[] nums5 = {1, 3, 5, 7, 9};
    public static final int[] nums6 = {2};

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));
        System.out.println(findMedianSortedArrays(nums5, nums6));
        System.out.println(findMedianSortedArrays2(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums3, nums4));
        System.out.println(findMedianSortedArrays2(nums5, nums6));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int left = 0;
        int right = nums1.length;

        int numsInLeft = (nums1.length + nums2.length) / 2;

        int i = 0;
        int j = 0;

        while (left < right) {
            i = (left + right) / 2 + 1;
            j = numsInLeft - i;
            if (nums1[i - 1] > nums2[j]) right = i - 1;
            else left = i;
        }
        i = left;
        j = numsInLeft - i;


        int nums1Left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1Right = i == nums1.length ? Integer.MAX_VALUE : nums1[i];
        int nums2Left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2Right = j == nums2.length ? Integer.MAX_VALUE : nums2[j];

        if ((nums1.length + nums2.length) % 2 == 1) return Math.min(nums1Right, nums2Right);
        else return
                (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;


    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays2(nums2, nums1);

        int left = 0;
        int right = nums1.length;

        int numsInLeft = (nums1.length + nums2.length) / 2;

        int mid1 = 0;
        int mid2 = 0;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = numsInLeft - i;

            int mid1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int mid1Right = (i == nums1.length) ? Integer.MAX_VALUE : nums1[i];
            int mid2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int mid2Right = (j == nums2.length) ? Integer.MAX_VALUE : nums2[j];

            if (mid1Left <= mid2Right) {
                mid1 = Math.max(mid1Left, mid2Left);
                mid2 = Math.min(mid1Right, mid2Right);
                left = i + 1;
            } else right = i - 1;
        }

        return (nums1.length+ nums2.length) % 2 == 1 ? mid2 : (mid1 + mid2) / 2.0;
    }
}
