class Solution {
    public int reverseDegree(String s) {
     int ans  = 0 ; 
     for(int i = 1 ; i<=s.length();i++){
        int idex = s.charAt(i-1) - 'a';
        int reverse = 26 - idex ; 
        ans += reverse*i ; 
     }
        return ans ; 
    }
}