class Solution {
    public void setZero(int[][] matrix , int row , int col , boolean[][]visited){
        for(int i = 0 ; i<matrix[0].length ; i++){
            if(matrix[row][i]!=0){
                visited[row][i] = true ; 
                matrix[row][i] = 0 ; 
            }
        }
        for(int i = 0 ; i<matrix.length ; i++){
            if(matrix[i][col]!=0){
                visited[i][col] = true ; 
                matrix[i][col] = 0 ; 
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length ; 
        boolean [][]visited = new boolean[m][n] ; 
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(!visited[i][j]&&matrix[i][j]==0){
                    visited[i][j]= true ; 
                    setZero(matrix , i , j , visited) ; 
                }
            }
        }
    }
}