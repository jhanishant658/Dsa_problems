class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length ; 
        Integer[][]dp = new Integer[n][n] ; 
       return helper(values , 0 , n-1 , dp);
    }
    public int helper(int[] values ,int start ,int end , Integer[][]dp){
        if(start+1 == end) return 0 ; 
        if(dp[start][end]!=null) return dp[start][end] ;
        int ans = Integer.MAX_VALUE  ; 
        for(int pnt = start+1 ; pnt<end ;pnt++){
            ans = Math.min(ans , values[start]*values[end]*values[pnt]+ helper(values , start , pnt , dp)+helper(values , pnt , end , dp));
        }
        dp[start][end] = ans ; 
        return dp[start][end] ; 
    }
}