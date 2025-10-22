class Solution {
    List<List<Integer>> answer  ; 
    public void subset(int [] nums , int idx , List<Integer> ans){
        answer.add(new ArrayList<>(ans));
        for(int i = idx ; i<nums.length ;i++){
            if(i>idx&&nums[i]==nums[i-1]) continue ; 
            ans.add(nums[i]);
            
            subset(nums , i+1 , ans);
            ans.remove(ans.size()-1);
        }
        return ;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        answer = new ArrayList<>();
        subset(nums , 0 , new ArrayList<>());
        return answer ; 
    }
}