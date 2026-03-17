class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int maxArea = Integer.MIN_VALUE ; 
        int row = matrix.length , col = matrix[0].length ; 
        for(int j = 0 ; j<col ; j++){
            for(int i = 1 ; i<row ; i++){
                 if(matrix[i-1][j]>=1&&matrix[i][j]>=1) matrix[i][j] += matrix[i-1][j] ; 
            }
        }
        for(int i = 0 ; i<row ; i++){
        Arrays.sort(matrix[i]);
         
          for (int j = col - 1; j >= 0; j--) {
                int height = matrix[i][j];
                int width = col - j; // Number of columns with height >= matrix[i][j]
                maxArea = Math.max(maxArea, height * width);
            }
        }
        
       
        return maxArea; 
    }
}