class Solution {
    public int binarySearch(int left , int right , int target , int[] nums){
        if(left>=nums.length) return -1 ;
        while(left<=right){
            int mid = (left+right)/2 ; 
            if(nums[mid]==target) return mid ; 
            if(nums[mid]<target) left = mid+1 ; 
            else right = mid - 1 ; 
        }
        return -1 ; 
    }
    public int search(int[] nums, int target) {
         int left = 0 ; 
         while(left<nums.length-1&&nums[left]<nums[left+1])left++;
         int idx = binarySearch(0 , left , target,nums) ; 
         if(idx==-1) return binarySearch(left+1 , nums.length-1 , target ,nums);
         return idx ; 
    }
}