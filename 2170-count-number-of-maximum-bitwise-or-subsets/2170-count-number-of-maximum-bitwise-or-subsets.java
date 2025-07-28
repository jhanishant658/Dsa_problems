class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr > maxOr) {
                maxOr = currentOr;
                count = 1;
            } else if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        // Include nums[index]
        dfs(nums, index + 1, currentOr | nums[index]);

        // Exclude nums[index]
        dfs(nums, index + 1, currentOr);
    }
}
