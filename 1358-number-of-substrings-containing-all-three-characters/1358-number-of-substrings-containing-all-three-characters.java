class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 1. Add current character first
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            
            // 2. Shrink window from the left as long as it's valid
            while (map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                // All substrings from index 'i' to the end of the string are valid
                ans += s.length() - i; 
                
                char leftChar = s.charAt(left);
                if (map.get(leftChar) == 1) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, map.get(leftChar) - 1); // Fixed subtraction
                }
                left++;
            }
        }
        return ans;
    }
}