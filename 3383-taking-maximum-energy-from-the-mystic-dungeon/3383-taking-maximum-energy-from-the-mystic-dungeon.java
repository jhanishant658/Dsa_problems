class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE , n = energy.length;
        int [] dp = new int [n];
        for(int i = n-1 ; i>=0; i--){
            if(i+k>=n) dp[i] = energy[i] ;
            else dp[i] = dp[i] = dp[i+k] +energy[i];
            max = Math.max(dp[i] , max);
        }
        return max ;
    }
}