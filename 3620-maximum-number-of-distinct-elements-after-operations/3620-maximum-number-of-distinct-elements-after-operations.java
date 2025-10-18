import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums); // sorting helps handle smaller numbers first
        Set<Integer> set = new HashSet<>();
        int nextAvilable = Integer.MIN_VALUE ; 
        for(int i = 0 ; i<nums.length ; i++){ 
            int  val = Math.max(nextAvilable , nums[i] - k );
            if(val<=nums[i]+k) {set.add(val) ;
                 nextAvilable = val+1 ; }
            
           
            
        }
        return set.size();
    }
}
