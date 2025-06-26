import java.util.*;

class Solution {
    public int maximumSwap(int num) {
        List<Integer> numbers = new ArrayList<>();
        
        // Convert number to digits (reversed)
        while (num > 0) {
            numbers.add(num % 10);
            num /= 10;
        }

        int left = -1, right = -1; // Declare before loop to use outside

        // Find the two digits to swap
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int small = i, large = i;
            for (int j = 0; j < i; j++) {
                if (numbers.get(small) < numbers.get(j) && numbers.get(j) > numbers.get(large)) {
                    large = j;
                }
            }
            if (large != i) {
                left = large;
                right = i;
                break;
            }
        }

        // Swap if needed
        if (left != -1 && right != -1) {
            Collections.swap(numbers, left, right);
        }

        // Convert list back to number
        int ans = 0;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            ans = ans * 10 + numbers.get(i);
        }

        return ans;
    }
}
