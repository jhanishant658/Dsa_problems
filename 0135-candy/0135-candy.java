import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        
        // Step 1: Give each child at least one candy
        Arrays.fill(dp, 1);
        
        // Step 2: Forward pass (left to right)
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        // Step 3: Backward pass (right to left)
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }

        // Step 4: Sum all the candies
        int totalCandies = 0;
        for (int candies : dp) {
            totalCandies += candies;
        }

        return totalCandies;
    }
}
