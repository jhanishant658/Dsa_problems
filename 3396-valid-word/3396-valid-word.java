class Solution {
     boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);  // Convert to lowercase to simplify check
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    boolean isConsonant(char ch) {
        ch = Character.toLowerCase(ch); // Convert to lowercase for uniformity
        return Character.isLetter(ch) && !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    public boolean isValid(String word) {
        if(word.length()<3)return false ; 
        int vowel = 0 ,consonent=0 ;
        for(int i = 0 ; i<word.length();i++){
            char ch = word.charAt(i);
            if(!Character.isLetter(ch)&&!Character.isDigit(ch))return false ; 
            if(!Character.isDigit(ch)){
            if(isVowel(ch)) vowel++;
            if(isConsonant(ch)) consonent++;
            }

        }
        return consonent!=0&& vowel!=0 ; 
    }
}