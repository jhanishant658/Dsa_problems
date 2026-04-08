class Solution {
     long mod = 1_000_000_007L;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int i = 0 ; i<queries.length ; i++){
            int val = queries[i][3];
            int idx = queries[i][0];
            int  k = queries[i][2] ; 
            int end = queries[i][1];
            while(idx<=end){
                nums[idx] = (int)(((long)nums[idx]*(long)val)%mod ); 
                idx = idx+ k ; 
            }
        }
        int xor = nums[0] ; 
        for(int i = 1 ; i<nums.length ;i++){
          xor = xor^nums[i] ; 
        }
        return xor ; 
    }
}