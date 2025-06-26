class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0 ; i<numRows ;i++){
            List<Integer> ans = new ArrayList<>();
            for(int j = 0 ; j<=i ;j++){
                if(j==0||i==j)ans.add(1) ;
                else  ans.add(answer.get(i-1).get(j)+answer.get(i-1).get(j-1));
            }
            answer.add(ans) ; 
        }
        return answer ; 
    }
}