class Solution {
    public int minChanges(String s) {
        int cnt = 0 ; 
    for(int i = 0 ; i<s.length();i+=2){
        if(s.substring(i,i+2).equals("01")||s.substring(i,i+2).equals("10"))cnt++;
    }  
    return cnt ;   
    }
}