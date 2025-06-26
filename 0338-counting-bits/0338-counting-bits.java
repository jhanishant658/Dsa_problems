class Solution {
    public int[] countBits(int n) {
       int[] dp = new int[n+1] ;
       dp[0] = 0 ; 
       for(int i = 1 ; i<=n ; i++){
        dp[i] = i%2 + dp[i/2];
       } 
       return dp ;
    }
}