class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer , List<Integer>> map = new HashMap<>() ; 
        for (int i = 0; i < nums.length; i++) {
            // Using computeIfAbsent is cleaner here
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> idx = entry.getValue();
                if(idx.size()>=3){
                    for (int i = 0; i <= idx.size() - 3; i++) {
                    ans = Math.min(ans, idx.get(i + 2) - idx.get(i));
                }
                }
    }
    return (ans==Integer.MAX_VALUE)? -1 : 2*ans ; 
  }
}