class Solution {
    public int maxArea(int[] height) {
         int left = 0 , right = height.length-1 ,maxArea = 0 ; 
         while(left<right){
            int Maxheight = Math.min(height[left], height[right]);
            int weidth = right - left ; 
            maxArea = Math.max(maxArea , Maxheight*weidth);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right-- ; 
            }
         }
         return maxArea ; 
    }
}