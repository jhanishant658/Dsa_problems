class Solution {
long mod = 1000000007 ; 
    public int maxProductPath(int[][] grid) {
     int m = grid.length , n = grid[0].length ; 
       long[][] maxProduct = new long[m][n] ; 
       long[][]minProduct = new long[m][n] ; 
       maxProduct[0][0] = minProduct[0][0] = grid[0][0] ; 
       for(int i = 1 ; i<m ; i++)maxProduct[i][0] = minProduct[i][0] = maxProduct[i-1][0]*grid[i][0] ; 
       for(int i = 1 ; i<n ; i++)maxProduct[0][i] = minProduct[0][i] = maxProduct[0][i-1]*grid[0][i] ; 
       for(int i = 1 ; i<m ; i++){
        for(int j = 1 ; j<n ; j++){
            if(grid[i][j]>=0){
                maxProduct[i][j] = Math.max(maxProduct[i][j-1] , maxProduct[i-1][j])*grid[i][j] ; 
                minProduct[i][j] = Math.min(minProduct[i][j-1] , minProduct[i-1][j])*grid[i][j] ;  
            }
            else{
                 minProduct[i][j] = Math.max(maxProduct[i][j-1] , maxProduct[i-1][j])*grid[i][j] ; 
                maxProduct[i][j] = Math.min(minProduct[i][j-1] , minProduct[i-1][j])*grid[i][j] ;  
            }
        }
       }
      long res = maxProduct[m-1][n-1] ; 
      if(res<0) return -1 ; 
      return (int) (res%mod) ; 
    }
}