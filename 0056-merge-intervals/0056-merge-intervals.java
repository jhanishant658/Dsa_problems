import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

         ans.add(intervals[0]);
         for(int i=1 ; i<intervals.length ; i++){
            if(ans.get(ans.size()-1)[1]>=intervals[i][0]){
                int [] a = new int[]{ans.get(ans.size()-1)[0] , Math.max(intervals[i][1] ,ans.get(ans.size()-1)[1])};
                ans.set(ans.size()-1 , a );
            }
            else {
                ans.add(intervals[i]);
            }
         }
        

        return ans.toArray(new int[ans.size()][]);
    }
}