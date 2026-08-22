class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0 , product = 1 ; 
        int digit = n ; 
        while(digit>=1){
            int dig = digit%10 ; 
            sum += dig ; 
            product *= dig ; 
            digit /= 10 ; 
        }
        return n%(product+sum)==0;
    }
}