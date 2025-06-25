class Solution {

    public long countPositive(int[] nums, int a, long mid) {
        int low = 0, high = nums.length;
        while (low < high) {
            int m = (low + high) / 2;
            if ((long) a * nums[m] <= mid) {
                low = m + 1;
            } else {
                high = m;
            }
        }
        return low;
    }

    public long countNegative(int[] nums, int a, long mid) {
        int low = 0, high = nums.length;
        while (low < high) {
            int m = (low + high) / 2;
            if ((long) a * nums[m] <= mid) {
                high = m;
            } else {
                low = m + 1;
            }
        }
        return nums.length - low;
    }

    public long countLessOrEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;
        for (int a : nums1) {
            if (a == 0) {
                if (mid >= 0) count += nums2.length;
            } else if (a > 0) {
                count += countPositive(nums2, a, mid);
            } else {
                count += countNegative(nums2, a, mid);
            }
        }
        return count;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L; // enlarged range for safety
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessOrEqual(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
