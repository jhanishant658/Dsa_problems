class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;          // pointer in s
        int j = 0;          // pointer in p
        int starIdx = -1;   // latest position of '*' in p
        int match = 0;      // position in s that corresponds to starIdx + 1

        while (i < s.length()) {
            // 1. current chars match, or pattern has '?'
            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            // 2. pattern has '*': record its position and move pattern pointer
            else if (j < p.length() && p.charAt(j) == '*') {
                starIdx = j;
                match = i;
                j++;                    // try to match zero chars first
            }
            // 3. mismatch but we had a previous '*': back‑track
            else if (starIdx != -1) {
                j = starIdx + 1;        // reset pattern pointer to after '*'
                match++;                // let '*' absorb one more char
                i = match;              // move string pointer accordingly
            }
            // 4. mismatch and no previous '*': not match
            else {
                return false;
            }
        }

        // consume any trailing '*' in the pattern
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        // match only if pattern fully consumed
        return j == p.length();
    }
}
