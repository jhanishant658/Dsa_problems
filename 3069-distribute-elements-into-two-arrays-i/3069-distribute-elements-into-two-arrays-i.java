class Solution {
    public int[] resultArray(int[] nums) {
        int [] arr1 = new int[nums.length];
        int [] arr2 = new int[nums.length];
        arr1[0] = nums[0] ; 
        arr2[0] = nums[1] ;
        int l1 = arr1[0] ; 
        int l2 = arr2[0] ; 
        int idx1 = 1 , idx2 = 1 ; 
        for(int i = 2 ; i<nums.length ; i++){
            if(l1>l2){
                arr1[idx1++] = nums[i] ; 
                l1 = nums[i] ; 
            }
            else{
                arr2[idx2++] = nums[i] ; 
                l2 = nums[i] ; 
            }
        }
        for(int i = idx1 ; i<idx1+idx2 ; i++){
            arr1[i] = arr2[i-idx1] ; 
        }
        return arr1 ; 
    }
}