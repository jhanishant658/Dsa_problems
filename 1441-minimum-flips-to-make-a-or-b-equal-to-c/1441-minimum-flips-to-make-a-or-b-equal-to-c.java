class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0) {
            int abit = a % 2;
            int bbit = b % 2;
            int cbit = c % 2;

            if (cbit == 1) {
                if (abit == 0 && bbit == 0) count++; // Need to flip one of them to 1
            } else {
                if (abit == 1) count++;
                if (bbit == 1) count++;
            }

            a /= 2;
            b /= 2;
            c /= 2;
        }
        return count;
    }
}
