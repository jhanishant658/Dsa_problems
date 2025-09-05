class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long a = num1 - (long) i * num2;

            if (a < i) continue; // skip instead of returning
            if (Long.bitCount(a) <= i) return i;
        }
        return -1;
    }
}
