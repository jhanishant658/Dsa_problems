class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int maxLen = 0, currLen = 0;
        for (int num : nums) {
            if (num == max) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 0;
            }
        }

        return maxLen;
    }
}
