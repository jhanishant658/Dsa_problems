class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        for(int num:basket1)map.put(num,map.getOrDefault(num,0)+1);
         for(int num:basket2)map.put(num,map.getOrDefault(num,0)-1);
         List<Integer> excess = new ArrayList<>() ; 
         int min = Integer.MAX_VALUE ; 
         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getKey() ;
            int diff = entry.getValue();
            if(diff%2!=0)return - 1 ; 
            for(int i = 0 ; i<Math.abs(diff)/2 ;i++)excess.add(val) ;
            min =Math.min(min , val);
         }
         //calculate cost 
         Collections.sort(excess) ; 
         long cost = 0 ;
         for(int i = 0 ;i<excess.size()/2 ;i++){
            cost+= Math.min(excess.get(i) , 2*min);
         }
        
        return cost;
    }
}
