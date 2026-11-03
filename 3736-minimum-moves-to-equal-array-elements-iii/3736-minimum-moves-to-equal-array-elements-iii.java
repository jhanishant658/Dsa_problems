class Solution {
    public int minMoves(int[] nums) {
        int moves = 0 , max = nums[0] ; 
        for(int i = 1 ; i<nums.length ; i++){
             if(nums[i]<=max) {moves += max-nums[i] ;} 
             else {
                moves += i*(nums[i]-max);
                max = nums[i] ; 
             }
        }
        return moves ; 
    }
}