import java.util.*;

class Solution {
    HashMap<Integer, Integer> map; 
    HashMap<Integer, Long> memo; 

    public long solve(List<Integer> nums, int idx) {
        if (idx >= nums.size()) return 0L;

        // ✅ Memoization check
        if (memo.containsKey(idx)) return memo.get(idx);

        // not take
        long skip = solve(nums, idx + 1);

        // take
        int j = lowerbound(nums, idx + 1, nums.get(idx) + 2);
        long take = (long) nums.get(idx) * map.get(nums.get(idx)) + solve(nums, j);

        long ans = Math.max(skip, take);

        memo.put(idx, ans); // ✅ store result
        return ans;
    }

    public int lowerbound(List<Integer> nums, int idx, int target) {
        int left = idx, right = nums.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);

        map = new HashMap<>();
        memo = new HashMap<>();

        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        List<Integer> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums); // ✅ make sure keys are sorted for lowerbound to work correctly

        return solve(nums, 0);
    }
}
