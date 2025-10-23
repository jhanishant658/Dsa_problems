class Solution {
    public boolean hasSameDigits(String s) {
        if (s.length() <= 2) return s.charAt(0) == s.charAt(s.length() - 1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            int a = ((s.charAt(i) - '0') + (s.charAt(i + 1) - '0')) % 10;
            sb.append(a);
        }
        
        return hasSameDigits(sb.toString());
    }
}
