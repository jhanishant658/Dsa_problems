class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[][] copy = new int[nums.length][2];  // Each element: [index, value]

        for (int i = 0; i < nums.length; i++) {
            copy[i][0] = i;        // store index
            copy[i][1] = nums[i];  // store value
        }

        // Step 1: Sort by value (ascending)
        Arrays.sort(copy, (a, b) -> Integer.compare(a[1], b[1]));
        int i = 0 ,j= nums.length-1 ; 
        while(i<j){
            if(copy[i][1]+copy[j][1]==target) return new int[]{copy[i][0] , copy[j][0]};
            else if(copy[i][1]+copy[j][1]<target)i++;
            else j-- ;
        }
        return new int[]{-1,-1};
    }
}