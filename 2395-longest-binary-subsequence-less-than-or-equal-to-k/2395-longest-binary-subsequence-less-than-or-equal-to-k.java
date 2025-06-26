class Solution {
    public int longestSubsequence(String s, int k) {
       StringBuilder sb = new StringBuilder();
       boolean take1 = true ; 
       for(int i= s.length()-1 ;i>=0 ;i--){
        if(s.charAt(i)=='0')sb.insert(0 ,'0');
        if(s.charAt(i)=='1'&&take1==true){
            sb.insert(0 ,'1') ;
            try{
              int num = Integer.parseInt(sb.toString(), 2);
              if(num>k) {sb.deleteCharAt(0);
               take1 = false ; }}
               catch(Exception e){
                sb.deleteCharAt(0);
                take1 = false ; 
               }
               
        }
       }
       return sb.toString().length();
    }
}

