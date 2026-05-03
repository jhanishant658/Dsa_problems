class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length()!=s.length()) return false ; 
        s = s + s ; 
        int len = goal.length()  ; 
        for(int i = 0 ; i<s.length()-len ; i++){
            if(s.substring(i , i+len).equals(goal)) return true ; 
        }
        return false ; 
    }
}