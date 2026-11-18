class Solution {
    public int minChanges(String s) {
        int cnt = 0 ; 
    for(int i = 0 ; i<s.length();i+=2){
        int pc = s.charAt(i);
        int c = s.charAt(i+1);
        if(c!=pc)cnt++;
    }  
    return cnt ;   
    }
}