import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0 ; 
       Arrays.sort(nums);
       Set<Integer> set = new HashSet<>() ; 
       int ele = nums[0] ; 
       set.add(nums[0]);
       int max =1 ;
       int maxlen = 1 ; 
       for(int i = 1; i<nums.length ;i++){
        if(set.contains(nums[i])){continue ;}
        else if(nums[i] == ele +1){
         max = max+1 ;

           maxlen = Math.max(maxlen , max);
            set.add(nums[i]);
            ele = nums[i] ; 
        }
        else{
            max = 1 ;
            ele = nums[i] ; 
        }
       }
       return maxlen ; 

  }
}
