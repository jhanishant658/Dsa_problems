class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        
        // Step 1: Count frequency difference
        for (int num : basket1) freq.put(num, freq.getOrDefault(num, 0) + 1);
        for (int num : basket2) freq.put(num, freq.getOrDefault(num, 0) - 1);
        
        List<Integer> excess = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;
        
        // Step 2: Build excess list and check for impossibility
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int diff = entry.getValue();
            minVal = Math.min(minVal, val);
            if (diff % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(diff) / 2; i++) {
                excess.add(val);
            }
        }
        
        Collections.sort(excess);
        long cost = 0;
        int n = excess.size();
        
        // Step 3: Calculate cost greedily using min element trick
        for (int i = 0; i < n / 2; i++) {
            cost += Math.min(excess.get(i), 2 * minVal);
        }
        
        return cost;
    }
}
