import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < intervals[i][0]) {
                // No overlap, add interval
                ans.add(intervals[i]);
            } else {
                // Overlap, merge interval
                int[] last = ans.get(ans.size() - 1);
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}