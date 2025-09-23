class Solution {
  public int ans(String v1, String v2) {
        int i = 0, j = 0;
        while (i < v1.length() || j < v2.length()) {
            int a = 0;
            while (i < v1.length() && v1.charAt(i) != '.') {
                int b = v1.charAt(i) - '0';
                a = a * 10 + b;
                i++;
            }

            int c = 0;
            while (j < v2.length() && v2.charAt(j) != '.') {
                int b = v2.charAt(j) - '0';
                c = c * 10 + b;
                j++;
            }

            System.out.println("a = " + a + " , c = " + c);

            if (a < c) return -1;
            if (a > c) return 1;

            // dot skip
            if (i < v1.length() && v1.charAt(i) == '.') i++;
            if (j < v2.length() && v2.charAt(j) == '.') j++;
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        return ans(version1, version2);
    }
}