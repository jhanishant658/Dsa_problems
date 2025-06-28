class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
      int[][] copy = new int[nums.length][2];  // nums.length rows, 2 columns
      int ans[] = new int[k ] ; 
for (int i = 0; i < nums.length; i++) {
    copy[i][0] = i;        // index
    copy[i][1] = nums[i];  // value
}
Arrays.sort(copy, (a, b) -> Integer.compare(a[1], b[1]));
// sort last k element according to index 
Arrays.sort(copy, nums.length-k, nums.length, (a, b) -> Integer.compare(a[0], b[0]));
//fill the ans
for(int i = 0 ;i<ans.length ;i++)ans[i] = copy[nums.length-k+i][1];
       
        return ans ; 
    }
}