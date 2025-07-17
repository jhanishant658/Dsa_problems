class Solution {
    public int maximumLength(int[] nums, int k) {
        int [][] dp = new int[k][k] ;int ans =0  ; 
        for(int i =  0 ; i<nums.length  ;i++){
            int curRem = nums[i]%k ;
            for(int prevRem= 0 ; prevRem<k ;prevRem++){
                dp[curRem][prevRem] = Math.max(dp[curRem][prevRem] , 1+dp[prevRem][curRem]);
                ans = Math.max(ans , dp[curRem][prevRem]);
            }
        }
        return ans ; 
    }
}