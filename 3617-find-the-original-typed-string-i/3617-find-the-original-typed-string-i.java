class Solution {
    public int possibleStringCount(String word) {
       int i = 0 ,ans = 1 ;
        while(i<word.length()){
            int j =i+1 ;
            while(j<word.length()&&word.charAt(j)==word.charAt(i))j++;
            ans+=j-i-1;
            i=j;
        }
        return ans ; 
    }
}