class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int []max = new int[nums.length] ; 
        int []min = new int[nums.length] ; 
        max[0] = nums[0] ; 
        min[nums.length-1] = nums[nums.length-1] ; 
        for(int i = 1 , j = nums.length-2 ; j>=0&&i<nums.length ; j-- ,i++){
            max[i] = Math.max(nums[i],max[i-1]);
            min[j] = Math.min(nums[j],min[j+1]);
        }
        for(int i = 0 ; i<nums.length ; i++){
            if(max[i]-min[i]<=k)return i ; 
        }
        return -1 ; 
    }
}