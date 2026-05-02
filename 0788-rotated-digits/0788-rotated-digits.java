import java.util.*;

class Solution {
    // Returns -1 if valid/good, or the index (0-based from right) of the bad digit
    public int getFirstInvalidIndex(int n) {
        int index = 0;
        int temp = n;
        int lastBadIndex = -1;
        
        while (temp > 0) {
            int digit = temp % 10;
            // 3, 4, 7 make the whole number invalid
            if (digit == 3 || digit == 4 || digit == 7) {
                lastBadIndex = index;
            }
            temp /= 10;
            index++;
        }
        return lastBadIndex;
    }

    public boolean isActuallyGood(int n) {
        String s = String.valueOf(n);
        // Must NOT have 3, 4, 7 AND MUST have at least one 2, 5, 6, 9
        if (s.contains("3") || s.contains("4") || s.contains("7")) return false;
        return s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9");
    }

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ) {
            int badIdx = getFirstInvalidIndex(i);
            
            if (badIdx == -1) {
                // No 3, 4, 7 found, now check if it actually rotates to a different number
                if (isActuallyGood(i)) ans++;
                i++;
            } else {
                // Optimization: Skip numbers that will definitely contain the bad digit
                // Example: If i=132, badIdx is 1 (the '3'). 
                // We skip to 140 by adding 10^1 - (132 % 10^1)
                int skip = (int) Math.pow(10, badIdx);
                i += skip - (i % skip);
            }
        }
        return ans;
    }
}