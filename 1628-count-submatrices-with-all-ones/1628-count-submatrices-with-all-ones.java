class Solution {
   public int numSubmat(int[][] mat) {
    int rows = mat.length, cols = mat[0].length;
    int res = 0;

    // Build histogram for each row
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (mat[i][j] != 0 && j > 0) {
                mat[i][j] += mat[i][j - 1]; // accumulate horizontally
            }
        }
    }

    // Count submatrices
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (mat[i][j] > 0) {
                int minWidth = mat[i][j];
                for (int k = i; k >= 0; k--) {
                    minWidth = Math.min(minWidth, mat[k][j]);
                    res += minWidth;
                }
            }
        }
    }

    return res;
}

}