class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int cnt = numBottles ; 
        numBottles = 0 ;
        int emp = cnt ; 
        while(emp>=numExchange){
            cnt++; 
            emp = emp-numExchange+1 ; 
            numExchange++ ; 
        }
        return cnt ; 
    }
}