class Solution {
    public int[] leftRightDifference(int[] nums) {
       int[] left = new int[nums.length];
       int[] right = new int[nums.length] ; 
       int i = 1 , j = nums.length-2 ;
        
       while(i<nums.length&&j>=0){
        left[i] = left[i-1] + nums[i-1] ; 
        right[j] = right[j+1] + nums[j+1] ; 
        i++;
        j-- ; 
       } 
       for(int k = 0 ; k<left.length ; k++){
        left[k] = Math.abs(left[k]-right[k]);
       }
       return left ; 
    }
}