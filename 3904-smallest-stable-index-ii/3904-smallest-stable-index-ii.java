
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i], rightMin[i + 1]);
        }

        
        int currentMax = 0; // Renamed from 'max' to avoid conflict with Math.max
        
        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            int diff = currentMax - rightMin[i];
            if (diff <= k ) {
                return i ; 
            }
        }
        return -1; 
    }
}