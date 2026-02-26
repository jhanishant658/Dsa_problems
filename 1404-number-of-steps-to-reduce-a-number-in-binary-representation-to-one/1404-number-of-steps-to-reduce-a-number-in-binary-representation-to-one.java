class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        // Process from right to left, stopping before the first character
        for (int i = s.length() - 1; i > 0; i--) {
            int digit = (s.charAt(i) - '0') + carry;
            
            if (digit % 2 == 1) { // Odd: add 1 (becomes even) then divide by 2
                steps += 2;
                carry = 1;
            } else { // Even: just divide by 2
                steps += 1;
            }
        }
        
        // Finally, if there is a carry left at the first position ('1' + 1 = 10)
        return steps + carry;
    }
}