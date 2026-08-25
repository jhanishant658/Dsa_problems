class Solution {
    public int missingMultiple(int[] nums, int k) {
       boolean[] ans = new boolean[100] ; 
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]%k==0){
                int idx = nums[i]/k ; 
                ans[idx-1]= true ;  
            }
        }
        for(int i = 0 ; i<ans.length ; i++){
            if(!ans[i]) return (i+1)*k ; 
        }
        return 101*k ; 
    }
}