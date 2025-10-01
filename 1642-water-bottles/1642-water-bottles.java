class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles ; 
        int emptyBottles = numBottles ; 
        numBottles = 0 ; 
       while(emptyBottles>=numExchange){
        numBottles = emptyBottles/numExchange ; 
        cnt+=numBottles ; 
        emptyBottles = emptyBottles%numExchange ;
        emptyBottles+=numBottles ;
        numBottles = 0 ; 
       }
        return cnt ; 
    }
}