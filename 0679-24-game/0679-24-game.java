import java.util.*;

class Solution {

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            nums.add((double) cards[i]);
        }
        return helper(nums);
    }

    public boolean helper(List<Double> nums) {
        int n = nums.size();
        if (n == 1) return Math.abs(24.0 - nums.get(0)) < 0.000001;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums.get(i);
                double b = nums.get(j);

                List<Double> opr = call(a, b);
                List<Double> next = new ArrayList<>();

                // baki numbers add karna
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                for (int l = 0; l < opr.size(); l++) {
                    next.add(opr.get(l));
                    if (helper(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    public List<Double> call(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > 0.000001) res.add(a / b);
        if (Math.abs(a) > 0.000001) res.add(b / a);
        return res;
    }
}
