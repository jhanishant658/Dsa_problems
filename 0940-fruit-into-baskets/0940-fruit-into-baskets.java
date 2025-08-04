class Solution {
    public int totalFruit(int[] fruits) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer ,Integer> map = new HashMap<>();
        int ans = 0 ;
        int count = 0 , j=0  ;
        for(int i = 0 ; i<fruits.length ;i++){
               
                map.put(fruits[i] ,map.getOrDefault(fruits[i] ,0)+1);
                set.add(fruits[i]);
            while(set.size()>=3&&j<fruits.length){
               map.put(fruits[j] ,map.get(fruits[j])-1);
               if(map.get(fruits[j])==0) set.remove(fruits[j]) ;
               j++;
               count-- ; 
            }
             count++;
             ans = Math.max(ans , count) ;
        }
        return ans ;
    }
}