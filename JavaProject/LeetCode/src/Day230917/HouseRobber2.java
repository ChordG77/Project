package Day230917;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 3
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 0 1 2
 * 12
 * 0
 * 0 1 2 3
 * 123
 * 2
 * <p>
 * 0 1 2 3 4
 * 01234
 * 00230
 * <p>
 * 012345
 * 012345
 * 002340
 * <p>
 * 0 1 2 3 4 5 6 7
 * 1234567
 * 23456
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124};
        System.out.println(rob(nums));
        System.out.println(robCircle(nums));
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else return Math.max(robNounCircle(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    robNounCircle(Arrays.copyOfRange(nums, 1, nums.length)));
    }


    private static int robNounCircle(int[] nums) {
        int score = 0;
        int score1 = 0;
        int score2 = 0;
        for (int num : nums) {
            score = Math.max(score2, score1 + num);
            score1 = score2;
            score2 = score;
        }
        return score;
    }

    private static int robCircle(int[] nums) {
        int score1 = 0;
        int score2 = 0;
        int subScore1 = 0;
        int subScore2 = 0;
        int subScore3 = 0;
        int subScore4 = 0;
        for (int i = 1; i < nums.length; i++) {
            score1 = Math.max(subScore2, subScore1 + nums[i]);
            subScore1 = subScore2;
            subScore2 = score1;
            if (i < 2 || i > nums.length - 2) continue;
            score2 = Math.max(subScore4, subScore3 + nums[i]);
            subScore3 = subScore4;
            subScore4 = score2;
        }
        return Math.max(score1, score2 + nums[0]);
    }
}
