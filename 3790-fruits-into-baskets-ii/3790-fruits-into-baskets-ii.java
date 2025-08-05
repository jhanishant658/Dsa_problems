class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean visited[] = new boolean[fruits.length];
        int ans =0 ;
        for(int i = 0 ; i<fruits.length ;i++){
            for(int j = 0 ;j<baskets.length ;j++){
                if(baskets[j]>=fruits[i]&&visited[j]==false){visited[j] = true ; 
                ans++;
                break ; }
            }
            
        }
        return fruits.length-ans ; 
    }
}