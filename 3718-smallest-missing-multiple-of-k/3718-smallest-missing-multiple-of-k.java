class Solution {
    public int missingMultiple(int[] nums, int k) {
        int idx = 1 ; 
       while(true){
        boolean found = false ; 
        int mul = idx * k ; 
        for(int i = 0 ; i<nums.length ; i++){
            if(mul==nums[i]){
                found = true ; 
                idx++;
                break ; 
            }
        }
        if(!found) return mul ; 
       }
    }
}