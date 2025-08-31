class Solution {
    public boolean solve(char[][]board){
        for(int i = 0 ;i<board.length;i++){
            for(int j = 0 ; j<board[0].length ;j++){
                if(board[i][j]=='.'){
                      for(char k = '1' ;k<='9' ;k++){
                        if(isValid(board , i , j , k)){
                            board[i][j] = k ;
                         if(solve(board)) return true ;
                         else 
                             board[i][j ] ='.' ; 
                        }
                      }
                      return false ; 
                }
            }
        }
        return true  ; 
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean isValid(char [][] board ,int row , int col , char num){
        // traverse in that row and col 
        for(int i= 0 ;i<board[0].length ;i++){
            if(board[row][i]==num) return false ;
            if(board[i][col]==num) return false ; 
            if(board[3*(row/3) +i/3][3*(col/3)+i%3]==num)return false ; 
        }
        return true ; 
        
    }
}