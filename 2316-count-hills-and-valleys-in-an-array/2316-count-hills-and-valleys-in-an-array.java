class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int[]right = new int [nums.length] ; 
        right[nums.length-1]= nums[nums.length-1] ; 
        for(int i = nums.length-2 ;i>=0 ; i--){
            if(nums[i]!=nums[i+1])right[i] = nums[i+1];
            else right[i] = right[i+1]; 
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] > nums[i - 1] && nums[i] > right[i]) ||
                (nums[i] < nums[i - 1] && nums[i] < right[i])) {
                    System.out.println(nums[i]) ; 
                ans++;
            }
        }
        return ans;
    }
}