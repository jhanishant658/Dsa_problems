class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i = 0, maxlen = 0;

        for (int j = 0; j < nums.length; j++) {
            // Shrink window until difference is <= 1
            while (nums[j] - nums[i] > 1) {
                i++;
            }

            // If difference is exactly 1, it's a valid window
            if (nums[j] - nums[i] == 1) {
                maxlen = Math.max(maxlen, j - i + 1);
            }
        }

        return maxlen;
    }
}
