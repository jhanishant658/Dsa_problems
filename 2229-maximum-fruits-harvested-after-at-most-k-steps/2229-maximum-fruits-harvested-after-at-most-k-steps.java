class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = startPos - k;
        int right = startPos + k;

        // Map position to fruit count
        Map<Integer, Integer> fruitMap = new HashMap<>();
        for (int[] fruit : fruits) {
            fruitMap.put(fruit[0], fruit[1]);
        }

        // Build fruit array in range [left, right]
        int[] fruitArray = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            fruitArray[i - left] = fruitMap.getOrDefault(i, 0);
        }

        int ans = 0;
        int sum = 0;
        int n = fruitArray.length;

        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += fruitArray[r];

            // Real world positions
            int posL = l + left;
            int posR = r + left;

            // Check cost to move from startPos to [posL...posR]
            int minSteps = Math.min(
                Math.abs(startPos - posL) + (posR - posL),  // go left then right
                Math.abs(startPos - posR) + (posR - posL)   // go right then left
            );

            while (minSteps > k) {
                sum -= fruitArray[l];
                l++;
                posL = l + left;
                minSteps = Math.min(
                    Math.abs(startPos - posL) + (posR - posL),
                    Math.abs(startPos - posR) + (posR - posL)
                );
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
