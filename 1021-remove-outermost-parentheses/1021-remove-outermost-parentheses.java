class Solution {
    public String removeOuterParentheses(String s) {
    int i = 0 , open = 0 , closed = 0 ; 
    StringBuilder sb = new StringBuilder() ; 
    while(i<s.length()-1){
        open = 1 ; 
        int j = i+1 ; 
        while(j<s.length()){
            if(s.charAt(j)=='(') open++;
            else closed++;
            if(open==closed){
                sb.append(s.substring(i+1,j));  
                break ; 
            }
            j++;
            
        }
        i = j + 1 ; 
        open = 0 ; 
        closed = 0  ; 
    }
    return sb.toString(); 
    }
}