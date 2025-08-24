class Solution {
    public int longestSubarray(int[] nums) {
       List<Integer> ans = new ArrayList<Integer>();
        int a= 0 ;
      for(int i = 0 ; i<nums.length ;i++){
        if(nums[i]==0){
            ans.add(a);
            a=0 ; 
        }
        else{
            a++;
        }
      }
      if(a!=0) ans.add(a);
      int b=0;
       a=0 ; 
      if(ans.size()==1&&ans.get(0)==0) return 0 ; 
       if(ans.size()==1) return ans.get(0)-1 ; 
      
      for(int i=0 ;i<ans.size();i++){
        if(i<=1){ a+=ans.get(i);
              b=a ; }
        else {
            b = b+ans.get(i)-ans.get(i-2);
            a=Math.max(a,b);
        }
      }
      return a ; 
    }
}