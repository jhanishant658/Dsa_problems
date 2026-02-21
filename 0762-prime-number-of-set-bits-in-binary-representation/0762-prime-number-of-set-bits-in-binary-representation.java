class Solution {
    public int isPrime(int n ){
        if(n<=1) return 0 ; 
        for(int i = 2 ; i<n ; i++){
            if(n%i==0) return 0 ; 
        }
        return 1 ; 
    }
    public int findBits(int n){
        int cnt = 0 ; 
        while(n>=1){
            if(n%2==1) cnt++ ; 
            n = n/2 ; 
        }
       return isPrime(cnt) ; 
    }
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0 ; 
        for(int i = left ; i<=right ; i++){
            cnt = cnt + findBits(i) ; 
        }
        return cnt ; 
    }
}