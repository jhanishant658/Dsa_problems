class Solution {
    public boolean solve(String s, String p) {
        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = (s.length() > 0) && 
                             (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 0 occurrence of preceding char OR
            // if firstMatch, move in string s
            return solve(s, p.substring(2)) || 
                   (firstMatch && solve(s.substring(1), p));
        } else {
            return firstMatch && solve(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatch(String s, String p) {
        return solve(s, p);
    }
}
