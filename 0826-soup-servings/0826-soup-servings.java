import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Double> memo = new HashMap<>();

    public double ans(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        double res = 0.25 * (
            ans(a - 100, b) +
            ans(a - 75, b - 25) +
            ans(a - 50, b - 50) +
            ans(a - 25, b - 75)
        );
        memo.put(key, res);
        return res;
    }

    public double soupServings(int n) {
        if (n >= 4800) return 1.0; // Optimization
        return ans(n, n);
    }
}
