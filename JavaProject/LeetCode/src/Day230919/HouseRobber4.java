package Day230919;


import java.util.Arrays;

/**
 * There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
 * <p>
 * The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
 * <p>
 * You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.
 * <p>
 * You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.
 * <p>
 * Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
 * <p>
 * Example 1:
 * Input: nums = [2,3,5,9], k = 2
 * Output: 5
 * <p>
 * Example 2:
 * Input: nums = [2,7,9,3,1], k = 2
 * Output: 2
 * <p>
 * 2 2 6 6 6
 */

public class HouseRobber4 {
    public static final int nums[] = {2, 7, 9, 3, 1};
    public static final int k = 2;

    public static void main(String[] args) {
        System.out.println(minCapability(nums, k));
    }

    public static int minCapability(int[] nums, int k) {
//        int upper = Arrays.stream(nums).max().getAsInt();
//        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = nums[0];
        int lower = nums[0];
        for (int i = 1; i < nums.length; i++) {
            upper = Math.max(upper, nums[i]);
            lower = Math.min(lower, nums[i]);
        }

        while (upper >= lower) {
            int mid = (upper + lower) >> 1;
            int count = k;
            int i = 0;
            while (i < nums.length) {
                if (nums[i] <= mid) {
                    count--;
                    i += 2;
                } else i++;
            }
            if (count <= 0) {
                upper = mid - 1;
            } else lower = mid + 1;
        }
        return lower;
    }
}
