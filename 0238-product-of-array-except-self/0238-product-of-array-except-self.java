class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1 , cnt = 0  ;
        for(int i = 0 ; i<nums.length ; i++){
           if(nums[i]==0)cnt++;
           else product *= nums[i] ; 
        }
        if(cnt>1) return new int[nums.length] ; 
        for(int i = 0 ; i<nums.length ; i++){
            if(cnt==0){
                nums[i] = product/nums[i] ; 
            }
            else if(cnt>0&&nums[i]!=0){
                nums[i] = 0  ;
            }
            else {
                nums[i] = product ; 
            }
        }
        return nums ; 
    }
}