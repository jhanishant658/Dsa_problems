import java.util.*;

class Solution {
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public boolean isTrue(String s, String t) {
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(t.charAt(i));

            if (c1 == c2) continue;
            if (!(isVowel(c1) && isVowel(c2))) return false;
        }
        return true;
    }

    public String solveVowelMatch(String s, String[] wordlist) {
        for (String word : wordlist) {
            if (isTrue(s, word)) return word;
        }
        return "";
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exactSet = new HashSet<>(Arrays.asList(wordlist));

        // lowercase -> first occurrence
        HashMap<String, String> lowerMap = new HashMap<>();
        for (String word : wordlist) {
            lowerMap.putIfAbsent(word.toLowerCase(), word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactSet.contains(q)) {
                ans[i] = q; // exact match
            } else if (lowerMap.containsKey(q.toLowerCase())) {
                ans[i] = lowerMap.get(q.toLowerCase()); // case-insensitive match
            } else {
                ans[i] = solveVowelMatch(q, wordlist); // vowel match
            }
        }
        return ans;
    }
}
