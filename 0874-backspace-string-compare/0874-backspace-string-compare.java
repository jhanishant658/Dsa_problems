class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder()  ;
        StringBuilder sb2 = new StringBuilder() ; 
        for(int i = 0 ;i<s.length() ;i++){
            if(s.charAt(i)=='#'){ 
                if(sb.length()==0) sb.append('#');
                sb.deleteCharAt(sb.length()-1);}
            else sb.append(s.charAt(i));
            
        }
        for(int i = 0 ;i<t.length() ;i++){
            if(t.charAt(i)=='#'){
                if(sb2.length()==0) sb2.append('#');
             sb2.deleteCharAt(sb2.length()-1);}
            else sb2.append(t.charAt(i));
        }
        return sb.toString().equals(sb2.toString()) ;
    }
}