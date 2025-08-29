class Solution {
    public long flowerGame(int n, int m) {
    long e1 = n/2 ,e2 = m/2 ;
      long o1 = n-e1 ,o2 = m-e2 ;
       return o2*e1+e2*o1 ;
    }
}