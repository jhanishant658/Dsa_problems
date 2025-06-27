class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> myMap = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!myMap.containsKey(key)) {
                List<String> mp = new ArrayList<>();
                mp.add(s);
                myMap.put(key, mp);
            } else {
                myMap.get(key).add(s); // ✅ fixed line
            }
        }

        return new ArrayList<>(myMap.values());
    }
}