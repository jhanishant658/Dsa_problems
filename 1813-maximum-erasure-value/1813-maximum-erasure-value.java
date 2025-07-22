class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        int sum = 0, maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {
            int val = nums[right];
            map.put(val, map.getOrDefault(val, 0) + 1);
            sum += val;

            while (map.get(val) > 1) {
                int lVal = nums[left];
                map.put(lVal, map.get(lVal) - 1);
                sum -= lVal;
                left++;
            }

            maxSum = Math.max(maxSum, sum);
            right++;
        }

        return maxSum;
    }
}
