class Solution {
        
    public int findMin(int i , int j , Integer[][] dp  , List<List<Integer>> triangle){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j) ; 
        }
        if (dp[i][j] != null) return dp[i][j];
        int down = triangle.get(i).get(j) + findMin(i+1 , j , dp , triangle);
        int diag = triangle.get(i).get(j) + findMin(i+1 ,j+1 ,dp , triangle);
        return dp[i][j] = Math.min(down ,diag);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size() ; 
        Integer[][] dp = new Integer[n][n];
       return findMin(0,0,dp,triangle);
    }
}

