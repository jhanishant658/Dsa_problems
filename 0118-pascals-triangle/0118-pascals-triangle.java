class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans = new ArrayList<>() ; 
          List<Integer> a = new ArrayList<>() ;
          a.add(1);
        ans.add(a) ;
        for(int i = 1 ; i<numRows;i++){
             List<Integer> an = new ArrayList<>();
           for(int j = 0 ; j<= i ;j++){
            if(j==0||j==i) an.add(1);
            else{
                an.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
           }
           ans.add(an) ; 
        }
        return ans ; 
    }
}