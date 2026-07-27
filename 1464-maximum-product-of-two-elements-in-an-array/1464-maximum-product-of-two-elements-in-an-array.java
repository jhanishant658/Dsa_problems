class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE , max2 = max ; 
         
        for(int i = 0 ; i<nums.length ; i++){
            if(max<nums[i]-1){
                max2 = max ; 
                max = nums[i]-1 ; 
            }
           else if(max2<nums[i]-1){
                max2 = nums[i]-1 ; 
            }
            else {
                continue ; 
            }
        }
        return max*max2 ; 
    }
}