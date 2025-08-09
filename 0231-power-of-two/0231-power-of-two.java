class Solution {
    public boolean isPowerOfTwo(int n) {
        String bits = Integer.toBinaryString(n);
       if(n<=0)return false ; 
            System.out.println(bits);
            for(int i=1 ;i<bits.length();i++){
                if(bits.charAt(i)=='1')return false ; 
            }
            return true ; 
    }
}