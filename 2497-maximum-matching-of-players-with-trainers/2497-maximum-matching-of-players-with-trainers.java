class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0 ,j= 0 ,ans=0 ;
        while(i<players.length){
            while(j<trainers.length){
            if(trainers[j]>=players[i]){
                ans++;
                j++;
                break ; 
            }
            j++;
            }
            i++;
        }
        return ans ; 
    }
}