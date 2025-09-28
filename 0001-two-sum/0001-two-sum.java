class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer ,List<Integer>> map = new HashMap<>() ;
       for(int i = 0 ;i<nums.length ; i++){
           map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
       }
       Arrays.sort(nums);
       int i = 0 , j = nums.length-1 ;
       while(i<j){
        if(nums[i]+nums[j]==target){
            if(nums[i]==nums[j]) return new int[]{map.get(nums[i]).get(0) ,map.get(nums[i]).get(1)};
            return new int[]{map.get(nums[i]).get(0) , map.get(nums[j]).get(0)} ; 
        }
        if(nums[i]+nums[j]<target) i++ ; 
        else j-- ;
       }
       return new int[]{-1 ,-1};
    }
}