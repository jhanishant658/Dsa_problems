class Solution {

    public void setZeroes(int[][] matrix) {
        boolean [][] visited = new boolean [matrix.length][matrix[0].length];
     for(int i = 0 ;i<matrix.length ;i++){
        for(int j = 0 ;j<matrix[0].length ;j++){
            if(!visited[i][j]&&matrix[i][j]==0){
                // go downward 
              for(int k = i ;k<matrix.length ;k++){
                 if(matrix[k][j]!=0){ matrix[k][j] = 0 ;
                     visited[k][j]=true ; 
                 }
              }
              // go upward 
              for(int k = i ;k>=0 ;k--){
                 if(matrix[k][j]!=0){ matrix[k][j] = 0 ;
                     visited[k][j]=true ; 
                 }
              }
              // go right 
              for(int k = j ;k<matrix[0].length ;k++){
                 if(matrix[i][k]!=0){ matrix[i][k] = 0 ;
                     visited[i][k]=true ; 
                 }
              }
              // go left 
              for(int k = j ;k>=0 ;k--){
                 if(matrix[i][k]!=0){ matrix[i][k] = 0 ;
                     visited[i][k]=true ; 
                 }
              }
              }
            }
        }
     }
 }
