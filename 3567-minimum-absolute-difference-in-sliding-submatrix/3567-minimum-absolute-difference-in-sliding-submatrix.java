class Solution {
    public int findMinDiff(int[][]grid , int row , int col , int k){
       HashSet<Integer> set = new HashSet<>() ; 
        // Set ko List mein badlo


        for(int i = row ; i<row+k ; i++){
            for(int j = col ; j<col+k ;j++){
                set.add(grid[i][j]); 
            }
        }
        if(set.size()<=1) return 0 ; 
        int ans = Integer.MAX_VALUE ; 
        List<Integer> list = new ArrayList<>(set) ; 
        Collections.sort(list);
        for(int i = 1 ; i<list.size() ; i++){
         ans = Math.min(ans , Math.abs(list.get(i)-list.get(i-1))) ; 
         if(ans==0) return 0 ; 
        }
        return ans ; 
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
     int[][] ans = new int[grid.length-k+1][grid[0].length-k+1] ; 
     for(int i = 0 ; i<grid.length-k+1 ; i++){
       for(int j = 0 ; j<grid[0].length-k+1 ; j++){
        ans[i][j] = findMinDiff(grid , i , j , k) ; 
       }
     }   
     return ans ; 
    }
}