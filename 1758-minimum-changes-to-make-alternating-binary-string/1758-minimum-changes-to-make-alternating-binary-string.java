class Solution {
    public int minOperations(String s) {
       int ans = 0 ,cnt = 0 ; 
       for(int i = 0 ; i<s.length();i++){
        if(s.charAt(i)=='0'&&i%2==0||s.charAt(i)!='0'&&i%2!=0) cnt++;
         if(s.charAt(i)=='0'&&i%2!=0||s.charAt(i)!='0'&&i%2==0) ans++;
       }
       return Math.min(ans , cnt);
    }
}