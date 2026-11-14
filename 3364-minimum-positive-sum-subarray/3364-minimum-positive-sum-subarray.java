class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE ; 
        for(int i = l ; i<=r ; i++){
            int sum = 0 ; 
            for(int j=0 ; j<i ; j++){
                sum+= nums.get(j);
            }
            for(int j = i ; j<nums.size();j++){
              if(sum>0) minSum = Math.min(minSum,sum);
                sum = sum + nums.get(j) - nums.get(j-i);
            }
             if(sum>0) minSum = Math.min(minSum,sum);
        }
        return (minSum==Integer.MAX_VALUE)? -1 : minSum ; 
    }
}