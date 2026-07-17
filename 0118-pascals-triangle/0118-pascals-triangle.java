class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1 ; i<=numRows ; i++){
            List<Integer> answer = new ArrayList<>();
            for(int j = 1 ; j<=i ; j++){
               if(j==1||j==i) answer.add(1);
               else answer.add(ans.get(ans.size()-1).get(j-2)+ans.get(ans.size()-1).get(j-1)) ; 
            }
            ans.add(answer);
        }
        return ans ;
    }
}