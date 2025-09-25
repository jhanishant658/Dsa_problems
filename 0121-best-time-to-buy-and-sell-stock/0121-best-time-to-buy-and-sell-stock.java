class Solution {
    public int maxProfit(int[] prices) {
      int min = prices[0] , res = 0 ; 
       for(int i= 0 ; i<prices.length ; i++){
         if(prices[i]<min) {
            min = prices[i] ; 
         }
         res = Math.max(res , prices[i] - min);
       } 
        return res ; 
    }
}