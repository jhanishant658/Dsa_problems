class Solution {
    void rotate(int[][]matrix){
        int row = matrix.length , col = row ; 
        for(int i = 0 ; i<row ; i++){
            for(int j = i+1 ; j<col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i] ;
                matrix[j][i] = temp ; 
            }
        }
        for(int j= 0 ; j<col ; j++){
            int low = 0 , high = col-1 ; 
            while(low<high){
                int temp = matrix[low][j] ; 
                matrix[low][j] = matrix[high][j];
                matrix[high][j] = temp ; 
                low++;
                high--; 
            }
        }
        
    }
    public boolean isEqual(int[][]mat , int[][]target){
        for(int i = 0 ; i<mat.length ; i++){
            for(int j = 0 ; j<mat.length ;j++){
                if(mat[i][j]!=target[i][j])return false ; 
            }
        }
        return true ; 
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        

    int rot = 90 ; 
    while(rot<=360){
           if(isEqual(mat,target))return true ; 
           rotate(mat);
           rot = rot+90 ; 
    }
    return false ; 
    }
}