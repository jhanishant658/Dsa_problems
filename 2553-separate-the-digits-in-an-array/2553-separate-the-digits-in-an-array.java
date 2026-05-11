class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for (int num : nums) {
            // Use a temporary list to get digits of current number
            List<Integer> temp = new ArrayList<>();
            if (num == 0) temp.add(0);
            
            while (num > 0) {
                temp.add(num % 10);
                num /= 10;
            }
            // Reverse only the digits of the CURRENT number
            Collections.reverse(temp);
            ans.addAll(temp);
        }

        // Convert the final list to the required int[] array
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}