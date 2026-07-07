class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0 , ans = 0 ; 
        while(n>0){
            int rem = n%10 ; 
    if(rem!=0){
        ans = ans*10 + rem ; 
            sum += rem; 
     } 
            n /= 10 ;
        }
    long ans1 = 0 ; 
    while(ans>0){
        ans1 = ans1*10 + ans%10 ; 
        ans /= 10 ; 
    }
       
        return ans1*sum ; 
    }
}