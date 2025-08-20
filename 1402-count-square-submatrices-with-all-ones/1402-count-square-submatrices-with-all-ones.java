class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0 ,  n=matrix.length ,m=matrix[0].length; 
        for(int i = 0 ;i<n ;i++){
            for(int j = 0  ;j<m;j++){
                if(matrix[i][j]!=0&&i>0&&j>0){
                    matrix[i][j] = Math.min(matrix[i][j-1],Math.min(matrix[i-1][j] ,matrix[i-1][j-1]))+1 ;
                    res+=matrix[i][j] ; 
                }
                if(matrix[i][j]!=0&&(i==0||j==0)){
                    res+=1;
                }
                System .out .print(matrix[i][j]);
            }
           //i=1 ,j=1
        }
        return res ;
    }
}