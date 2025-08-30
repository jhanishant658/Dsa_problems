class Solution {
    public boolean isValidSudoku(char[][] board) {
       HashSet<String> set = new HashSet<>();
       for(int i = 0 ;i<board.length ;i++){
        for(int j = 0 ; j<board.length ;j++){
            if(board[i][j]=='.'){ continue ;}
             if(!set.add(board[i][j] + "in row"+i )){
                return false ; 
            }
             if(!set.add(board[i][j] + "in col"+j )){
                return false ; 
            }
             if(!set.add(board[i][j] + "in gd"+i/3 +j/3)){
                return false ; 
            }

        }
           } 
           return true;
    }
}