class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        if(grid[0].length==0||grid[0][0]>k) return 0 ; 
        int cnt = 1 ; 
        int row = grid.length , col = grid[0].length ; 
        for(int i = 0 ; i<row ; i++){
            for(int j = 0 ; j<col ; j++){
                
                if(i>0&&j>0){
                    grid[i][j] = grid[i-1][j] + grid[i][j-1] +grid[i][j] - grid[i-1][j-1]; 
                    if(grid[i][j]<=k)cnt++ ; 
                }
               else if(i==0&&j>0){
                    grid[i][j] = grid[i][j-1]+grid[i][j] ; 
                    if(grid[i][j]<=k)cnt++ ;
                }
                else if(j==0&&i>0){
                    grid[i][j] = grid[i-1][j]+grid[i][j] ; 
                    if(grid[i][j]<=k)cnt++ ;
                }
                else{
                    continue ; 
                }
            }
        }
        return cnt ; 
    }
}