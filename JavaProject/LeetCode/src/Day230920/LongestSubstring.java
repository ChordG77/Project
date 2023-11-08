package Day230920;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * 0 <= s.length <= 5 * 104
 */
public class LongestSubstring {

    private static final String s = "pwwkew";

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = -1;

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
           if(map.containsKey(s.charAt(i))) {
               left = Math.max(left, map.get(s.charAt(i)));
           }
           max = Math.max(max, i - left);
           map.put(s.charAt(i), i);

        }

        return max;
    }
}
