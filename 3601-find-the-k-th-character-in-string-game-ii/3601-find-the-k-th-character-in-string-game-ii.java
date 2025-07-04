class Solution {
    public char kthCharacter(long k, int[] operations) {
        long index = k-1;
        int res = 0;


        for (int i = 0; i < operations.length; i++) {
            int bit = (int)(index%2);
            index/=2 ; 
            if (bit == 1 && operations[i] == 1) {
                res++;
            }
            
        }

        return (char)('a' + (res % 26));
    }
}
