class Solution {
    public String findSum(String s){
        int sum = 0 ; 
        for(int i = 0 ; i<s.length();i++){
            sum += s.charAt(i) -'0';
        }
        return String.valueOf(sum);
    }
    public String digitSum(String s, int k) {
    if(s.length()<=k) return s ; 
   StringBuilder sb = new StringBuilder() ; 
        for(int i = 0 ; i<s.length();i+=k){
            if(i+k>=s.length())sb.append(findSum(s.substring(i,s.length())));
            else  sb.append(findSum(s.substring(i,i+k)));
        }
        return digitSum(sb.toString(),k);
    }
}