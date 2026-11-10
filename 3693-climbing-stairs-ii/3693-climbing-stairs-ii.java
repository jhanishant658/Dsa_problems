class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[costs.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0 ; i<costs.length&&i<3;i++){
            dp[i]= costs[i] +(i+1)*(i+1);
        }
        for(int i = 0 ; i<costs.length ; i++){
       for(int j = i+1 ; j<=i+3&&j<costs.length ; j++){
        dp[j] = Math.min(dp[j],dp[i]+costs[j]+(j-i)*(j-i));
       }
        }
        return dp[costs.length-1];
    }
}