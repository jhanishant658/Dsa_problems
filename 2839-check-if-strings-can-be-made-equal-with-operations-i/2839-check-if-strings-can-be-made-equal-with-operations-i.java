class Solution {
   
    public boolean canBeEqual(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1) ; 
        for(int i = 0 ; i<2; i++){
            if(sb.toString().equals(s2)) return true ; 
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)!=s2.charAt(i+2)) return false ;
                
int j = i+2;
char temp = sb.charAt(i);

sb.setCharAt(i, sb.charAt(j));

sb.setCharAt(j, temp);
            }
        }
        return sb.toString().equals(s2);
    }
}