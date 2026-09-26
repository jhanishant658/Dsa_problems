class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> map = new HashMap<>() ; 
        for(int i = 0 ; i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        int i = 0 ; 
        StringBuilder ans = new StringBuilder() ; 
        while(i<s.length()){
            if(s.charAt(i)!='('){ans.append(s.charAt(i));
             i++ ; }
            else {
                int j = i+1 ; 
                while(s.charAt(j)!=')') j++ ; 
                String a = s.substring(i+1 , j) ; 
                if(map.containsKey(a)) ans.append(map.get(a));
                else ans.append('?');
                i = j+1 ; 

            }
        }
        return ans.toString();
    }
}