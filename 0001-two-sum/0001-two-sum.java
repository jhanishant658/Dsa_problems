class Solution {
    public int[] twoSum(int[] nums, int target) {
      
 for(int i = 0; i < nums.length-1; i++) {
    for(int j = i+1; j < nums.length;j++){
if(nums[j]+ nums[i]==target){
   
   return new int [] {i, j};
      
}
    }
 }
        return new int[]{nums[0],nums[1]};  // This will return the first two elements of the array as per the problem statement. If you want the indices, you'll need to modify the return statement accordingly.
    }
}