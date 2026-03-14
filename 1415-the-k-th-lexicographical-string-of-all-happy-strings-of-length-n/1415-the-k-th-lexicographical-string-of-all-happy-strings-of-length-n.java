class Solution {
    public String getHappyString(int n, int k) {
       if(k > 3 * (1 << (n-1))) return "";
int blockSize = 1 << (n-1);
       StringBuilder ans = new StringBuilder() ;
       char[] chars = new char[]{'a','b','c'};
       int first  = (k-1)/blockSize ; 
       k = k - first*blockSize ; 
       ans.append(chars[first]);
       for(int i = 1 ; i<n ;i++){
        blockSize /= 2 ; 
        char[] options = new char[2] ; 
       int idx = 0 ;
      for(char a : chars){
        if(a!=ans.charAt(ans.length()-1))options[idx++] = a ; 
      }
      int pick = (k-1)/blockSize ; 
      k = k- pick*blockSize ; 
      ans.append(options[pick]);

       }
        return ans.toString();
    }
}