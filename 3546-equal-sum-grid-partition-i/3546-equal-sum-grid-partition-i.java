class Solution {
    public boolean checkSum(long[]arr){
        long total = arr[arr.length-1] ; 
        for(int i = 0 ; i<arr.length ;i++){
            if(arr[i]==total-arr[i])return true ; 
        }
        return false ; 
    }
    public boolean canPartitionGrid(int[][] grid) {
        int row = grid.length , col = grid[0].length ; 
        long[] rowSum = new long[row];
        long[] colSum = new long[col];
        for(int i = 0 ;i<row ; i++){
            long sum = 0 ; 
            for(int j = 0 ; j<col ; j++){
            sum += grid[i][j] ; 
            }
            if(i==0) rowSum[0] = sum ; 
            else rowSum[i] = rowSum[i-1] + sum ; 
        }
        for(int j = 0 ; j<col ; j++){
            long sum = 0 ; 
            for(int i = 0 ;i<row ; i++){
                sum += grid[i][j] ; 
            }
            if(j==0) colSum[0] = sum ; 
            else colSum[j] = colSum[j-1] + sum ;
        }
       return checkSum(rowSum)||checkSum(colSum);
    }
}