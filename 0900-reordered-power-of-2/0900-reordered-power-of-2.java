class Solution {
     public boolean reorderedPowerOf2(int n) {
        // Digit frequency of n
        int[] freqN = countDigits(n);
        int len = String.valueOf(n).length();

        // Check all powers of two up to a reasonable limit (2^0 to 2^30)
        for (int i = 0; i < 31; i++) {
            int pow = 1 << i; // 2^i
            if (String.valueOf(pow).length() == len) {
                if (Arrays.equals(freqN, countDigits(pow))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Helper to count digit frequency
    private int[] countDigits(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        return freq;
    }
}