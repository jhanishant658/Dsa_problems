class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0 , maxIdx = 0 ; 
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i]<nums[minIdx]) minIdx = i ; 
            if(nums[i]>nums[maxIdx]) maxIdx = i ; 
        }
        int begin = Math.min(minIdx , maxIdx);
        int end = Math.max(maxIdx , minIdx);
        return Math.min(end+1 ,Math.min(nums.length-begin , begin +1 +nums.length-end) ) ; 
    }
}