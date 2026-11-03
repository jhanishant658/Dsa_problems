class Solution {
    public int minMoves(int[] nums) {
       int sum = 0  ,max = 0 ; 
       for(int num:nums){
         max = Math.max(num , max);
        sum += num ; 
       }
       return nums.length*max - sum ; 
    }
}