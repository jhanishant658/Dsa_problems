class Solution {
  public int binarySearch(int i, int[] arr, int target) {
    int start = i;
    int end = arr.length - 1;
    int bestJ = i; // Initialize with i because i <= j is a requirement
    
    while (start <= end) {
        int mid = start + (end - start) / 2; // Prevents overflow
        
        if (arr[mid] >= target) {
            bestJ = mid;      // This index is valid! Save it as a candidate.
            start = mid + 1;  // Try to find an even larger index further right.
        } else {
            end = mid - 1;    // Value is too small, look to the left.
        }
    }
    return bestJ - i; 
}
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0 ; 
        for(int i = 0 ; i<nums1.length ; i++){
          ans = Math.max(ans , binarySearch(i , nums2 , nums1[i])) ; 
        }
        return ans ; 
    }
}