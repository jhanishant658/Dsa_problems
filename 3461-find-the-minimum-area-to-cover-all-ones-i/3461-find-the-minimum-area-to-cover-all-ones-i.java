class Solution {
    public int minimumArea(int[][] grid) {
        int min =Integer.MAX_VALUE , max = 0 ,count = 0 ;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ;i<grid.length ;i++){
            for(int j = 0 ;j<grid[0].length ;j++){
                if(grid[i][j]==1){ 
                     min =Math.min(min,j+1) ;
                       max = Math.max(max ,j+1) ;
                      count++ ;
                 }
            }
        }
        if(count==0)return 0 ; 
        
          int start = Integer.MAX_VALUE,end = 0 ; 
        for(int i = 0 ;i<grid.length ;i++){
           
            for(int j = 0 ;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    start = Math.min(i , start);
                    end = Math.max(i ,end) ;
                    break ; 
                }
            }
            
        }
        System.out.print(max+" " +min +" "+start +" " +end);
        return (max-min+1)*(end - start+1) ; 
    }
}