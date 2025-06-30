class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int  maxlen = 0;
      HashMap<Integer,Integer>map = new HashMap();
       for(int i = 0 ;i<nums.length ;i++){
        map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
       }
      for(int j = 0 ;j<nums.length-1 ;j++){
        if(nums[j+1]-nums[j]==1)maxlen=Math.max(maxlen , map.get(nums[j+1])+map.get(nums[j]));
      }
        return maxlen;
    }
}
