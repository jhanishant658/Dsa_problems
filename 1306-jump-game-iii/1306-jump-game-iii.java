class Solution {
   HashSet<Integer> set = new HashSet<>() ; 
    public boolean canReach(int[] arr, int start) {
        if(set.contains(start)||start<0|| start>=arr.length) return false ; 
        set.add(start);
        if(arr[start]==0) return true ;
        boolean ans1 = canReach(arr , start+arr[start]);
        boolean ans2 = canReach(arr,start - arr[start]);
        return ans1||ans2 ; 
    }
}