class Solution {
    int ans[]=new int[2];
    public int findLeft(int[]nums ,int target){
        int a =-1 ,left =0 ,right = nums.length-1;
        while(left<=right){
            int mid =(left+right)/2;
            if(nums[mid]==target){a=mid ; right =mid-1;}
            else if(nums[mid]<target)left=mid+1;
            else right=mid-1;
        }
        return a ; 
    }
    public int findRight(int []nums , int target){
        int a =-1 ,left =0 ,right = nums.length-1;
        while(left<=right){
            int mid =(left+right)/2;
            if(nums[mid]==target){a=mid ; left=mid+1;}
            else if(nums[mid]<target)left=mid+1;
            else right=mid-1;
        }
        return a ; 
    }
    public int[] searchRange(int[] nums, int target) {
       ans[0]=findLeft(nums,target);
       ans[1] = findRight(nums ,target) ; 
        return ans;
    }
}