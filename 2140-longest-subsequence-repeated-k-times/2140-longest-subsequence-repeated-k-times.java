import java.util.*;

class Solution {

    // ----------------- helper fields kept for the whole DFS/BFS run -------------
    private String original;      // the original input string s
    private int k;                // required repetition count
    private int[] limit = new int[26];  // per-letter upper bound (freq / k)

    // ---------------------------------------------------------------------------
    // 1.  Keep only letters whose total occurrences allow at least one full copy
    //     in the answer, and record how many times each may appear.
    // ---------------------------------------------------------------------------
    private String possibleAnswer(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder usable = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            limit[i] = freq[i] / k;       // how many copies of this letter allowed
        }

        // Produce a string that contains each usable character limit[i] times,
        // but in reverse-alphabetical order so that later BFS tries bigger letters first.
        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < limit[i]; j++) {
                usable.append((char) (i + 'a'));
            }
        }
        return usable.toString();
    }

    // ---------------------------------------------------------------------------
    // 2.  Breadth-first search to build the longest, lexicographically largest
    //     candidate subsequence that repeats k times.
    // ---------------------------------------------------------------------------
    private String findPermutation(String candidates) {

        // queue holds strings that *already* pass the k-times subsequence test
        Queue<String> q = new ArrayDeque<>();
        q.offer("");

        String best = "";

        // Convert to array once for speed
        char[] cand = candidates.toCharArray();

        while (!q.isEmpty()) {
            String cur = q.poll();

            // Try to extend with each candidate letter, from 'z' down to 'a'
            for (char ch : cand) {
                String next = cur + ch;

                // prune: do not exceed per-letter limit
                if (!withinLimit(next)) continue;

                if (ksequencePossible(next)) {
                    // store for further expansion
                    q.offer(next);

                    // update best (longer wins; if equal length, lexicographically larger wins)
                    if (next.length() > best.length()
                            || (next.length() == best.length() && next.compareTo(best) > 0)) {
                        best = next;
                    }
                }
            }
        }
        return best;
    }

    // check that no letter in str uses more than limit[letter] copies
    private boolean withinLimit(String str) {
        int[] cnt = new int[26];
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            if (++cnt[idx] > limit[idx]) return false;
        }
        return true;
    }

    // ---------------------------------------------------------------------------
    // 3.  Is  t  repeated k times a subsequence of original?
    //     O(|s|) two-pointer scan.
    // ---------------------------------------------------------------------------
    private boolean ksequencePossible(String t) {
        int i = 0;              // index inside t
        int repeat = 0;         // how many full copies matched so far

        for (char c : original.toCharArray()) {
            if (c == t.charAt(i)) {
                i++;
                if (i == t.length()) {    // finished one copy of t
                    repeat++;
                    if (repeat == k) return true;
                    i = 0;                // start the next copy
                }
            }
        }
        return false;
    }

    // ---------------------------------------------------------------------------
    // Main API for LeetCode
    // ---------------------------------------------------------------------------
    public String longestSubsequenceRepeatedK(String s, int k) {
        this.original = s;
        this.k = k;

        String usable = possibleAnswer(s, k);
        return findPermutation(usable);
    }
}
