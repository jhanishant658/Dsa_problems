class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i<nums.length ;i++)set.add(Integer.parseInt(nums[i] ,2));
        int j = 0 ;
        while(set.contains(j))j++;
        StringBuilder s = new StringBuilder(Integer.toBinaryString(j));
        while(nums.length-s.length()>0)s.insert(0,'0');
        return s.toString();
    }
}