class Solution {
    public int maxSubArray(int[] nums) {
     int ans = Integer.MIN_VALUE , sum = ans ; 
      for(int i = 0 ; i<nums.length ; i++){
        if(nums[i]>ans&&ans<0) ans= 0 ; 
      ans += nums[i] ;
      sum = Math.max(sum , ans); 
      }  
      return sum ; 
    }
}