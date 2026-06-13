class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer , Character> map = new HashMap<>();
        char ch1 = 'z' ; 
        for(int i = 0 ; i<26 ; i++){
            map.put(i , ch1);
            ch1-- ; 
        }
         for(int i = 0 ; i<words.length ; i++){
            int sum = 0 ; 
            String str = words[i];
           for(char ch : str.toCharArray()){
            int idx = ch - 'a';
             sum += weights[idx];
            }
            sum = sum % 26 ; 
            sb.append(map.get(sum));
        }
        return sb.toString();
    }
}