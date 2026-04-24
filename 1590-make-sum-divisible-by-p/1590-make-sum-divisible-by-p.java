import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 1. Target remainder nikalon
        int targetRem = (int) (totalSum % p);
        if (targetRem == 0) return 0;

        // 2. HashMap initialize karo (Remainder -> Index)
        HashMap<Integer, Integer> remMap = new HashMap<>();
        remMap.put(0, -1); // Starting point handle karne ke liye

        int curSumRem = 0;
        int minLen = nums.length;

        // 3. Array par iterate karo
        for (int i = 0; i < nums.length; i++) {
            // Current remainder calculate karo
            curSumRem = (curSumRem + nums[i]) % p;

            // Target remainder jo peeche dhundna hai
            int neededRem = (curSumRem - targetRem + p) % p;

            // Agar map mein hai, toh length update karo
            if (remMap.containsKey(neededRem)) {
                minLen = Math.min(minLen, i - remMap.get(neededRem));
            }

            // Current remainder ko latest index ke saath store karo
            remMap.put(curSumRem, i);
        }

        // Agar poora array hi hatana pad raha hai, toh -1 return karo
        return minLen >= nums.length ? -1 : minLen;
    }
}