import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private int[] arr1;
    private int[] arr2;
    private Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.arr1 = nums1;
        this.arr2 = nums2;
        freqMap = new HashMap<>();
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = arr2[index];
        int newVal = oldVal + val;
        
        // Update frequency map
        freqMap.put(oldVal, freqMap.get(oldVal) - 1);
        if (freqMap.get(oldVal) == 0) {
            freqMap.remove(oldVal);
        }

        arr2[index] = newVal;
        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num : arr1) {
            int target = tot - num;
            count += freqMap.getOrDefault(target, 0);
        }
        return count;
    }
}