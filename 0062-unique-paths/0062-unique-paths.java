class Solution {
    public int uniquePaths(int m, int n) {
     int [][] grid = new int[m][n] ; 
      grid[0][0] = 1 ; 
     for(int i = 1 ; i<n ; i++){
        grid[0][i] = 1 ; 
        System.out.println("minimum path for " +0 +"and"+i+"is " + grid[0][i]);
     }
     for(int i = 1 ; i<m ;i++){
        grid[i][0] = 1 ; 
         System.out.println("minimum path for " +i +"and"+0+"is " + grid[i][0]);
     }
     for(int i=1 ; i<m ; i++){
        for(int j= 1 ; j<n ; j++){
            grid[i][j] = grid[i-1][j] +grid[i][j-1]  ;
             System.out.println("minimum path for " +i +"and"+j+"is " + grid[i][j]); 
        }
     }
     return grid[m-1][n-1] ; 
    }
}