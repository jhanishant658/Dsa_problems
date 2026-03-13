class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long)1e18;
        long ans = right;

        while(left <= right){

            long mid = left + (right-left)/2;

            if(canFinish(mid, mountainHeight, workerTimes)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    boolean canFinish(long T, int H, int[] workers){

        long total = 0;

        for(int t : workers){

            long val = (2*T)/t;

            long k = (long)((Math.sqrt(1 + 4*val) - 1)/2);

            total += k;

            if(total >= H)
                return true;
        }

        return false;
    }
}