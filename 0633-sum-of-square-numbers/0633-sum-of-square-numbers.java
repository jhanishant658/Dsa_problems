class Solution {
    public boolean judgeSquareSum(int c) {
        // Initialize pointers: right bound only needs to go up to sqrt(c)
        long left = 0;
        long right = (long) Math.sqrt(c);
        
        while (left <= right) {
            // Use long to prevent integer overflow during multiplication
            long sumOfSquares = left * left + right * right;
            
            if (sumOfSquares == c) {
                return true; 
            } else if (sumOfSquares < c) {
                left++; // Sum is too small, increase the lower bound
            } else {
                right--; // Sum is too big, decrease the upper bound
            }
        }
        
        return false;
    }
}