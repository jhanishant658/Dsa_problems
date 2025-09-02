class Solution {
    public int numberOfPairs(int[][] points) {
        int ans = 0 ; 
       for(int i = 0 ; i<points.length ;i++){
        for(int j = 0 ; j<points.length ;j++){
            int [] a= points[i] ; 
            int [] b = points[j] ;
            if(i==j
             || !(a[0]<=b[0]&&a[1]>=b[1])) continue ; 
        
             boolean illegal = false;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                     if (points.length == 2) {
                    ans++;
                    continue;
                }
                    int[] pointTmp = points[k];
                    boolean isXContained =
                        pointTmp[0] >=a[0] && pointTmp[0] <= b[0];
                    boolean isYContained =
                        pointTmp[1] <= a[1] && pointTmp[1] >= b[1];
                    if (isXContained && isYContained) {
                        illegal = true;
                        break;
                    }
                }
                if(!illegal) ans++;
        }
       
       }
       return ans ;
    }
}