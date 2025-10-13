class Solution {
    public boolean anagram(String s1 , String s2){
        if(s1.length()!=s2.length()) return false ; 
       
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
                arr2[s2.charAt(i) - 'a']++;
                }
            
        return Arrays.equals(arr1, arr2);
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();

          ans.add(words[words.length-1]);
        for(int i = words.length-2 ;i>=0;i--){
              if(anagram(words[i], ans.get(ans.size()-1))){
                ans.remove(ans.size()-1);
              }
              ans.add(words[i]);
        }
        Collections.reverse(ans);
        return ans ; 
    }
}