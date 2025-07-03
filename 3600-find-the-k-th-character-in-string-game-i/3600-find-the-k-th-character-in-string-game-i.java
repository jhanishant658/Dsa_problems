class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        if(k==1)return 'a' ; 
        while(sb.length()<k){
            String s1 = sb.toString();
            StringBuilder sb1 = new StringBuilder();
            for(int i = 0 ;i<s1.length();i++){
                char ch = s1.charAt(i);
             char nextChar = (char)(ch + 1);
             sb1.append(nextChar);
            }
            sb.append(sb1);

        }
        return sb.charAt(k-1); 
    }
}