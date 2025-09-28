class Solution {
    public int largestPerimeter(int[] nums) {
       Arrays.sort(nums); 
      int par = 0 ;
      for(int i = 0 ; i<=nums.length-3 ; i++ ){
        if(nums[i]+nums[i+1]>nums[i+2]){
            par = Math.max(par , nums[i]+nums[i+1]+nums[i+2]);
        }
      }
      return par ; 
    }
}