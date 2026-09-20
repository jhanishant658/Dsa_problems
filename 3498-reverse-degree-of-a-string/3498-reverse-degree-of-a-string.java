class Solution {
    public int reverseDegree(String s) {
        HashMap<Character , Integer> map = new HashMap<>() ; 
        char letter = 'a';
        int i = 26  ; 
        while(i>0){
            
            map.put(letter++ , i--);
            
           
        }
        int ans = 0 ; 
        for(int k = 0 ; k<s.length();k++){
            
            ans += map.get(s.charAt(k))*(k+1);
            
        }
        return ans ; 
    }
}