class Solution {
    public int solve(String text, HashSet<Character> set, int start, int count) {
        if (start >= text.length()) return count; // recursion ka base case

        int i = start;
        boolean flag = false; // ye batayega ki is word me broken letter mila ya nahi

        while (i < text.length()) {
            if (set.contains(text.charAt(i))) {
                flag = true; // broken letter mil gaya
            }
            if (text.charAt(i) == ' '||i==text.length()-1) { // word ka end
                if (flag == false) count++; // agar broken letter nahi mila to word type ho sakta hai
                i++; 
                break; // next word pe chale jao
            }
            i++;
        }

        return solve(text, set, i, count); // recursion call for next word
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++)
            set.add(brokenLetters.charAt(i));

        return solve(text, set, 0, 0);
    }
}
