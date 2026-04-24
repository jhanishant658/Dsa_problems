class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0 , r = 0 , x = 0 ; 
        for(int i = 0 ; i<moves.length();i++){
            if(moves.charAt(i)=='L') l++ ; 
            else if(moves.charAt(i)=='R') r++;
            else x++ ; 
        }
        return Math.abs(l-r)+ x ; 
    }
}