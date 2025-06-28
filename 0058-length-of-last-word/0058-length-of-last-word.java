class Solution {
    public int lengthOfLastWord(String s) {
        int i=0 ,ans = 0 ,ans1 =0 ;  
        while(i<s.length()){
      if(s.charAt(i)==' ')ans1 = 0 ;
      if(s.charAt(i)!=' ')ans1++;
      if(ans1!=0)ans = ans1 ; 
      i++;
        }
        return ans ; 
    }
}