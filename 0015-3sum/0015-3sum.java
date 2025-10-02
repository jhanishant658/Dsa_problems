import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // Sort the array to avoid duplicates easily
        Arrays.sort(nums);
        
        int n = nums.length;
      for(int i = 0 ; i<n-2 ; i++){
        if(i>0&&nums[i]==nums[i-1]) continue ; 
        int left = i+1 , right = n-1 ; 
        while(left<right){
            if(nums[left]+nums[right]+nums[i]==0){
                List<Integer> arr = Arrays.asList(nums[i], nums[left], nums[right]);
                  res.add(arr) ;
                  left++ ;
                  right--;
                  while(left<nums.length&&nums[left]==nums[left-1]){
                    left++;
                  }
                  while(right>0&&nums[right]==nums[right+1]){
                    right--; 
                  }
            }
            else if(nums[left]+nums[right]+nums[i]<0){
                left++;
            }
            else{
                right--; 
            }
        }
      }
        
        return res;
    }
}
