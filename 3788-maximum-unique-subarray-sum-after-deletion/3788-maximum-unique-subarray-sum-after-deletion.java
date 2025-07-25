class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = nums[0]; 
        set.add(nums[0]) ; 
        for(int i = 1 ; i<nums.length ;i++){
            if(!set.contains(nums[i])){
                
             ans =Math.max( Math.max(ans , ans+nums[i]) , nums[i]);
               
            }
             set.add(nums[i]);
        }
        return ans ; 
    }
}