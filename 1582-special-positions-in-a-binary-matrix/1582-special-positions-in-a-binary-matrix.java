class Solution {
    public int special(int[][]mat , int i , int j){
        for(int k = 0 ; k<mat[0].length;k++){
            if(k==j) continue ; 
            else if(mat[i][k]==1) return 0 ; 
        }
        for(int k = 0 ; k<mat.length ;k++){
            if(k==i) continue ; 
           else if(mat[k][j]==1) return 0 ; 
        }
        return 1 ; 
    }
    public int numSpecial(int[][] mat) {
        int cnt = 0 ; 
       for(int i = 0 ; i<mat.length ; i++){
        int j = 0 ; 
        while(j<mat[0].length&&mat[i][j]==0) j++;
        if(j!=mat[0].length) cnt += special(mat ,i , j);
       } 
       return cnt ; 
    }
}