class Solution {
    public int minSwaps(int[][] grid) {
        int[] trailing = new int[grid[0].length] ; 
        for(int i = 0 ; i<grid.length ;i++){
            for(int j = grid.length-1 ;j>=0&&grid[i][j]!=1 ;j--){
                 trailing[i]++ ; 
            }
            
        }
        int swap = 0 ; 
    for(int i = 0 ; i<trailing.length-1 ;i++){
        int need = trailing.length-i-1 ; 
        if(need>trailing[i]){
            int j = i+1 ;
            while(j<trailing.length&&trailing[j]<need)j++ ; 
            if(j>=trailing.length) return -1 ; 
            for(int k = j ; k>i ;k--){
                int temp = trailing[k] ;
                trailing[k] = trailing[k-1] ;
                trailing[k-1] = temp ; 
                swap++ ; 
            }
        }
    }
        return swap  ; 
    }
}