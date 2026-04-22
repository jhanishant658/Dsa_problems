class Solution {
    public boolean check(String s1 ,String s2){
        int cnt = 0 ; 
        for(int i = 0 ; i<s1.length() ;i++){
            if(s1.charAt(i)!=s2.charAt(i)) cnt++ ; 
        }
        return cnt<=2 ; 
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>() ; 
        for(int  i = 0 ; i<queries.length ; i++){
            for(int j = 0 ; j<dictionary.length ;j++){
                if(check(queries[i] , dictionary[j])){
                    ans.add(queries[i]);
                    break ; 
                }
            }
        }
        return ans  ; 
    }
}