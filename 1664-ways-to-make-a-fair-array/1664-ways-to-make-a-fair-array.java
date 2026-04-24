class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int evenSumAfter = 0, oddSumAfter = 0;
        int evenSumBefore = 0, oddSumBefore = 0;
        int count = 0;

        // 1. Calculate the total sum of even and odd positions initially
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) evenSumAfter += nums[i];
            else oddSumAfter += nums[i];
        }

        // 2. Iterate through each element and simulate removing it
        for (int i = 0; i < n; i++) {
            // Remove current element from "After" sums
            if (i % 2 == 0) evenSumAfter -= nums[i];
            else oddSumAfter -= nums[i];

            // Check if fair: (Even before + Odd after) == (Odd before + Even after)
            if (evenSumBefore + oddSumAfter == oddSumBefore + evenSumAfter) {
                count++;
            }

            // Add current element to "Before" sums for the next iteration
            if (i % 2 == 0) evenSumBefore += nums[i];
            else oddSumBefore += nums[i];
        }

        return count;
    }
}