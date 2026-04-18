class Solution {
    public int mirrorDistance(int n) {
       StringBuilder sb = new StringBuilder(String.valueOf(n)).reverse();
       return Math.abs(n-Integer.parseInt(sb.toString()));
    }
}