class Solution {
    int pow = 0 ; 
    public int invert(int n ){
        if(n==1) return 0 ; 
        return (int)Math.pow(2,pow) ; 
    }
    public int bitwiseComplement(int n) {
        if(n==0) return 1 ; 
      int ans = 0  ; 
      while(n>0){
        ans = ans + invert(n%2);
         n /= 2 ; 
         pow++;
      }  
      return ans ; 
    }
}