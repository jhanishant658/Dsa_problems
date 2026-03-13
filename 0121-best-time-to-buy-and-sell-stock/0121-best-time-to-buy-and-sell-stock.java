class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0] ,profit = 0 ;
        for(int i = 1 ; i<prices.length ;i++){
            if(prices[i]-buy<0) buy = prices[i];
            profit = Math.max(profit , prices[i]-buy);
        }
        return profit ; 
    }
}