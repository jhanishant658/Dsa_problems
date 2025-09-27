class Solution {
public double ans(double x, int n) {
    long N = n; // convert to long to avoid overflow

    if (N == 0) return 1;

    if (N < 0) {
        return 1.0 / power(x, -N);
    } else {
        return power(x, N);
    }
}

private double power(double x, long n) {
    if (n == 0) return 1;
    if (n % 2 == 0) {
        return power(x * x, n / 2);
    } else {
        return x * power(x, n - 1);
    }
}

    public double myPow(double x, int n) {
        return ans(x , n);
    }
}