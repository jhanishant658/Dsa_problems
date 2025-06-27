class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        dp[n] = 1;  // base case: empty string has 1 way
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0; // '0' cannot be decoded
            } else {
                dp[i] = dp[i + 1]; // one digit

                // check if two-digit number is valid (10 to 26)
                if (i + 1 < n) {
                    int twoDigit = Integer.parseInt(s.substring(i, i + 2));
                    if (twoDigit >= 10 && twoDigit <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }

        return dp[0];
    }
}
