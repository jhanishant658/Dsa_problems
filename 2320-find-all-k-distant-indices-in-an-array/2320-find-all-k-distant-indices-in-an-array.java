class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int i=0 , j= 0 ;
     while(i<nums.length&&j<nums.length){
        while(j<nums.length&&nums[j]!=key)j++;
        if(i-j>k)j++;
        if(j<nums.length&&nums[j]==key){
 if(Math.abs(i-j)<=k)ans.add(i);
   i++;
        } 
        
     }  
     return ans ; 
    }
}