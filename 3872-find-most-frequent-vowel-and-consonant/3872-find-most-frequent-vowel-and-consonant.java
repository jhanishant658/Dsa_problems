class Solution {
    public  boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch); 
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxFreqSum(String s) {
        HashMap<Character , Integer> vowel = new HashMap<>();
        HashMap<Character , Integer> cons = new HashMap<>();
        int max1 = 0 , max2 = 0 ; 
        for(int i=0 ;i<s.length() ;i++){
            if(isVowel(s.charAt(i))){
                vowel.put(s.charAt(i) ,vowel.getOrDefault(s.charAt(i) ,0)+1) ;
                max1 = Math.max(max1 , vowel.get(s.charAt(i)));
            }
            else{
                cons.put(s.charAt(i) ,cons.getOrDefault(s.charAt(i) ,0)+1) ;
                max2 = Math.max(max2 , cons.get(s.charAt(i)));
            }
        }
        return max1+max2 ; 

    }
}