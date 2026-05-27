class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt = 0 ; 
        HashMap<Character , Integer> map = new HashMap<>() ; 
        for(int i = 0 ; i<word.length();i++){
            // track first occurence od cappital letter 
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                map.put(ch,Math.min(i , map.getOrDefault(ch , Integer.MAX_VALUE)));
            }
            // track last occurence of small letter 
            else{
                map.put(ch , Math.max(i , map.getOrDefault(ch ,Integer.MIN_VALUE))) ; 
            }
        }
        HashSet<Character> set = new HashSet<>() ; 
        for(int i = 0 ; i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))||set.contains(word.charAt(i))) continue ; 
            char ch = Character.toUpperCase(word.charAt(i));
            if(map.containsKey(ch)&&map.get(ch)>map.get(word.charAt(i))) cnt++;
            set.add(word.charAt(i));
        }
        return cnt ; 
    }
}