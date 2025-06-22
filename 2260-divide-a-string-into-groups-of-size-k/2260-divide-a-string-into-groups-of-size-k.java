class Solution {
    public String[] divideString(String s, int k, char fill) {
        int a = s.length()/k;
        if(s.length()%k!=0)a++;
         String []ans = new String[a];
         int i = 0 ;
         a=0 ; 
         while(i<s.length()){
          StringBuilder sb = new StringBuilder();
            int j = i ;
            while(j<i+k){
                if(j>=s.length())sb.append(fill);
                else{
                    sb.append(s.charAt(j));
                }
                j++;
            }
          
             ans[a] = sb.toString();
             a++;
            i=j;
         }
         return ans ; 
    }
}