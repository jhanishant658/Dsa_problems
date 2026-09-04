class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n =  nums.length ; 
        int []min = new int[n] ; 
        
        min[n-1] = nums[n-1] ; 
        for(int j = n-2 ; j>=0 ; j--){
             min[j] = Math.min(nums[j],min[j+1]);
        }
        int max = Integer.MIN_VALUE ; 
        for(int i = 0 ; i<n ; i++){
            max = Math.max(max , nums[i]);
            if(max-min[i]<=k)return i ; 
        }
        return -1 ; 
    }
}