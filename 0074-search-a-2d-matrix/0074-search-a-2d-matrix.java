class Solution {
   public boolean binary(int [] arr , int target){
    int left = 0 , right = arr.length -1 ; 
    while(left<=right){
       int mid = (left+right)/2;
       if(arr[mid]==target) return true ; 
      else if(arr[mid]<target) left = mid+1 ; 
       else right = mid -1 ; 
    }
    return false; 
   }
    public boolean searchMatrix(int[][] matrix, int target) {
       int srow = 0 , erow = matrix.length-1;
       while(srow<=erow){
        int mid = (srow+erow)/2;
        if(matrix[mid][0]<=target&&target<=matrix[mid][matrix[0].length-1]){
            return binary(matrix[mid] , target);
        }
        if(matrix[mid][matrix[0].length-1]<target){
            srow = mid+1 ; 
        }
        else{
            erow = mid-1 ; 
        }
       }
       return false ; 
    }
}