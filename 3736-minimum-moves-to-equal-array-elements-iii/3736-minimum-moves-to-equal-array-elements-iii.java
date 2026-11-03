class Solution {
    public int minMoves(int[] nums) {
        int moves = 0 , max = nums[0] ; 
        int i = 0 ; 
        for(int num : nums){
             if(num<=max) {moves += max-num ;} 
             else {
                moves += i*(num-max);
                max = num ; 
             }
             i++;
        }
        return moves ; 
    }
}