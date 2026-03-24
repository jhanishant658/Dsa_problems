class Solution {
    int mod = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;

        int[] arr = new int[size];
        int k = 0;

        // flatten
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[i][j] % mod;
            }
        }

        long[] prefix = new long[size];
        long[] suffix = new long[size];

        prefix[0] = arr[0];
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i]) % mod;
        }

        suffix[size - 1] = arr[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i]) % mod;
        }

        int[][] ans = new int[m][n];
        k = 0;

        for (int i = 0; i < size; i++) {
            long left = (i > 0) ? prefix[i - 1] : 1;
            long right = (i < size - 1) ? suffix[i + 1] : 1;

            int val = (int)((left * right) % mod);

            ans[i / n][i % n] = val;
        }

        return ans;
    }
}