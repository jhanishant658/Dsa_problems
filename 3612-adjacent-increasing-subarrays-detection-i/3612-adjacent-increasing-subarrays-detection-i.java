class Solution {
    boolean check(List<Integer> nums , int i , int k){
        for(int a = i+1 ; a<nums.size()&&a<i+k ; a++){
           if(nums.get(a)<=nums.get(a-1)) return false ; 
        }
        return true ; 
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for(int i = 0 ; i<=nums.size()-2*k ; i++){
            if(check(nums , i , k)&&check(nums , i+k , k)) {
                System.out.println(i +"and " +(i+k));
                return true ; } 
        }
        return false ; 
    }
}