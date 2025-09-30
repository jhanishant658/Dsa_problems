class Solution {
    public int sum(List<Integer> nums){
        if(nums.size() == 1) return nums.get(0); 
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < nums.size(); i++){
            ans.add((nums.get(i) + nums.get(i-1)) % 10); // mod 10 required by problem
        }
        return sum(ans);
    }

    public int triangularSum(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            ans.add(num);
        }
        return sum(ans);
    }
}
