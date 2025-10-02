class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); 
        int min = Integer.MAX_VALUE , n = nums.length , minSum = 0 ;
        for(int i = 0 ; i<n-2 ; i++){
           int left = i+1 , right = n-1 ;  
           while(left<right){
            int sum = nums[left] +nums[right]+nums[i] ; 
            min = Math.min(min , Math.abs(sum-target));
            if(min==Math.abs(sum-target)) minSum = sum ; 
            if(sum==target) return sum ; 
            if(sum<target) left++ ;
            else right -- ; 
           }

        }
        return minSum ; 
    }
}