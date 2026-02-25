class Solution {

    public int cntBits(int n){
        int cnt = 0;
        while(n > 0){
            if(n % 2 != 0) cnt++;
            n = n / 2;
        }
        return cnt;
    }

    public int[] sortByBits(int[] arr) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int cnt = cntBits(arr[i]);

            if(!map.containsKey(cnt)){
                map.put(cnt, new ArrayList<>());
            }

            map.get(cnt).add(arr[i]);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        int idx = 0;

        for(int i = 0; i < keys.size(); i++){

            List<Integer> ans = map.get(keys.get(i));
            Collections.sort(ans);

            for(int j = 0; j < ans.size(); j++){
                arr[idx++] = ans.get(j);
            }
        }

        return arr;
    }
}