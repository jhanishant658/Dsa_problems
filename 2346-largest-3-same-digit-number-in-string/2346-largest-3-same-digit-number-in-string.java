class Solution {
    public boolean check(String s){
        for(int i =1 ;i<3 ; i++){
            if(s.charAt(i)!=s.charAt(i-1)) return false ;
        }
        return true ; 
    }
    public String largestGoodInteger(String num) {
          String max = "0";
        for(int i = 0 ; i<=num.length() - 3 ;i++){
                     String s = num.substring(i, i + 3) ; 
            if (check(s)&&Integer.parseInt(max)<=Integer.parseInt(s) ) {
                max = String.valueOf(s);
            }
                
        }
        if(max.equals("0")) return "";
        return max ; 
    }
}