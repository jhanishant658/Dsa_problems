class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length ; 
        int[] dp = new int[n];
        int ans = 0 ,sum = nums[0]; 
        for(int i = 1 ; i<n ; i++){
           ans += nums[i]*i ; 
           sum += nums[i] ; 
        } 
        dp[0] = ans ; 
        int res = ans ; 
        for(int i = 1 ; i<n ;i++){
            dp[i] = dp[i-1] + sum  - n*nums[n-i] ; 
            res = Math.max(res , dp[i]) ; 
        }
        return res ; 
    }
}