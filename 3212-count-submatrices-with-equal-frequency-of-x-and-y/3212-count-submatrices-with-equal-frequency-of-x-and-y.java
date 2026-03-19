class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int[][][] ans = new int[grid.length][grid[0].length][2] ; 
        int cnt = 0 ; 
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(i==0&&j==0){
                    if(grid[i][j]=='X')ans[0][0][0] = 1 ; 
                    if(grid[i][j]=='Y')ans[0][0][1] = 1 ; 
                }
                else if(i==0&&j>0){
                     int x = ans[i][j-1][0] ; 
                     int y = ans[i][j-1][1] ;  
                 if(grid[i][j]=='X') x++ ; 
                 
                if(grid[i][j]=='Y')y++ ; 
                 ans[i][j][0] = x ;
                 ans[i][j][1] = y ; 
                if(x==y&&x>0)cnt++ ; 
                }
                else if(i>0&&j==0){
                   int x = ans[i-1][j][0] ; 
                     int y = ans[i-1][j][1] ;  
                 if(grid[i][j]=='X') x++ ; 
                 
                if(grid[i][j]=='Y')y++ ; 
                 ans[i][j][0] = x ;
                 ans[i][j][1] = y ; 
                if(x==y&&x>0)cnt++ ; 
                }
                else{
                    int x = ans[i][j-1][0] +ans[i-1][j][0] -ans[i-1][j-1][0] ; ; 
                     int y = ans[i][j-1][1] +ans[i-1][j][1] -ans[i-1][j-1][1];  
                 if(grid[i][j]=='X') x++ ; 
                 
                if(grid[i][j]=='Y')y++ ; 
                 ans[i][j][0] = x ;
                 ans[i][j][1] = y ; 
                if(x==y&&x>0)cnt++ ;  
                }
            }
        }
        return cnt ; 
    }
}