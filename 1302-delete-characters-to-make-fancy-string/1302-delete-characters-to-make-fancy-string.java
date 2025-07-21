class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<s.length()&&i<2;i++){
            sb.append(s.charAt(i));
        }
        for(int i= 2;i<s.length();i++){
            if(s.charAt(i-2)==s.charAt(i)&&s.charAt(i)==s.charAt(i-1)) continue ;
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}