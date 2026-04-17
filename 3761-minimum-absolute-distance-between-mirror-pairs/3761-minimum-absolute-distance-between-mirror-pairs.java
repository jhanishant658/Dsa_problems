class Solution {
    public String reverseIntToString(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n)).reverse();
        // Remove leading zeros (e.g., 120 -> "021" -> "21")
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        // Map stores: Number String -> Its most recent index
        HashMap<String, Integer> lastSeenIndex = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            String currentStr = String.valueOf(nums[j]);
            
            // We need to find an 'i' such that reverse(nums[i]) == nums[j]
            // This is the SAME as saying nums[i] == reverse(nums[j]) 
            // EXCEPT for the leading zero rule. 
            
            // Let's stick to the problem: reverse(nums[i]) == nums[j]
            // So we check if our map contains a number whose REVERSE is currentStr.
            // Actually, a simpler way: When we see nums[i], we store its REVERSE.
            
            String revI = reverseIntToString(nums[j]);

            // If we find nums[j] in the map, it means some previous reverse(nums[i]) matched it
            if (lastSeenIndex.containsKey(currentStr)) {
                ans = Math.min(ans, j - lastSeenIndex.get(currentStr));
            }

            // Important: Store the reverse of the current number to be found by a future nums[j]
            // We only care about the latest index to get the minimum distance
            lastSeenIndex.put(revI, j);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}