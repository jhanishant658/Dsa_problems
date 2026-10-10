class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        if(nums1.length==1){
            long diff = Math.abs(nums1[0]-nums2[0]) - k1 - k2;
            if(diff>=0) return diff*diff ; 
            else return 0 ; 
        }
        long total  = 0 ; 
   PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
   HashMap<Integer,Integer> map = new HashMap<>() ; 
        for(int i = 0 ; i<nums2.length ; i++){
            int num = Math.abs(nums2[i]-nums1[i]);
            if(num==0) continue ;
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
                maxHeap.offer(num);
            }
            total += num ; 
        } 
        long k = k1+k2 ; 
        if(k>=total) return 0 ; 
        while(k>0&&!maxHeap.isEmpty()){
            int val = maxHeap.poll();
            long freq = map.get(val);
            if(freq<=k){
                map.remove(val);
                boolean isNew = !map.containsKey(val - 1);
                map.put(val-1 , map.getOrDefault(val-1 ,0)+(int)freq);
                k = k-freq ; 
                if(val-1>0&& isNew)maxHeap.offer(val-1);
            }
            else{
                map.put(val ,(int)( freq-k));
                boolean isNew = !map.containsKey(val - 1);
                map.put(val-1 ,map.getOrDefault(val-1,0)+(int)k);
                k=0 ; 
                maxHeap.offer(val);
                if(val-1>0&& isNew)maxHeap.offer(val-1);
            }
        }
        long sum = 0 ; 
        while(maxHeap.size()!=0){
            int val = maxHeap.poll() ;
            long freq = map.get(val); 
            sum += freq*Math.pow(val,2) ; 
        }
        return sum ; 
    }
}