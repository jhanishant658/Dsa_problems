class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        // Build the keypad map
        HashMap<Character, String> map = new HashMap<>();
        char ch = 'a';
        for (char digit = '2'; digit <= '9'; digit++) {
            int lettersCount = (digit == '7' || digit == '9') ? 4 : 3;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lettersCount && ch <= 'z'; i++) {
                sb.append(ch++);
            }
            map.put(digit, sb.toString());
        }

        List<String> ans = new ArrayList<>();
        ans.add(""); // Start with an empty string to build combinations

        for (int i = 0; i < digits.length(); i++) {
            String letters = map.get(digits.charAt(i));
            List<String> temp = new ArrayList<>();

            for (String combination : ans) {
                for (int j = 0; j < letters.length(); j++) {
                    temp.add(combination + letters.charAt(j));
                }
            }

            ans = temp; // Update the answer list
        }

        return ans;
    }
}
