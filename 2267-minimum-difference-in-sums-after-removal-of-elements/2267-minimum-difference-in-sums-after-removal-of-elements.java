import java.util.*;

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;
        
        long[] leftSum = new long[len];
        long[] rightSum = new long[len];
        
        // MaxHeap to keep track of largest n elements on the left
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftCurrentSum = 0;
        
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
            leftCurrentSum += nums[i];
            
            if (maxHeap.size() > n) {
                leftCurrentSum -= maxHeap.poll();
            }
            
            if (i >= n - 1) {
                leftSum[i] = leftCurrentSum;
            }
        }
        
        // MinHeap to keep track of smallest n elements on the right
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightCurrentSum = 0;
        
        for (int i = len - 1; i >= 0; i--) {
            minHeap.add(nums[i]);
            rightCurrentSum += nums[i];
            
            if (minHeap.size() > n) {
                rightCurrentSum -= minHeap.poll();
            }
            
            if (len - i >= n) {
                rightSum[i] = rightCurrentSum;
            }
        }
        
        long minDiff = Long.MAX_VALUE;
        // Try all partition points between n and 2n
        for (int i = n - 1; i < 2 * n; i++) {
            minDiff = Math.min(minDiff, leftSum[i] - rightSum[i + 1]);
        }
        
        return minDiff;
    }
}
