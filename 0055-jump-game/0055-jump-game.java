class Solution {
    public boolean canJump(int[] nums) {
       int pos = 0 ,i=0; 
       while(i<=pos){
         if(pos>=nums.length-1) return true ; 
         pos = Math.max(pos , i+nums[i]);
         i++;
       }
       return (pos>=nums.length-1)?true :false;
    }
}