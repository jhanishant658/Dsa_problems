class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int maxDist = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                // Valid pair, record distance and try to increase j
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                // nums1[i] is too large, move i forward
                i++;
                // Optimization: Ensure j is at least i to satisfy i <= j
                if (j < i) j = i;
            }
        }
        return maxDist;
    }
}