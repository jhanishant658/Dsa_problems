class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        // Repeatedly add 'word' to sb and check if it's in sequence
        while (true) {
            sb.append(word);
            if (sequence.contains(sb.toString())) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}