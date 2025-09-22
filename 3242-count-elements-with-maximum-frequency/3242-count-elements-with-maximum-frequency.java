class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer ,Integer> map = new HashMap<>() ; 
        int max = 0 ; 
        for(int i = 0  ;i<nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] ,0)+1) ; 
            max = Math.max(max , map.get(nums[i])) ; 
        }
        int cnt = 0 ; 
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==max)cnt++;
        }
        return max*cnt ; 
    }
}