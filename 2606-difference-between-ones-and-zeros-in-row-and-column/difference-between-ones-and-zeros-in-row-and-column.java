class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] onesRow = new int[m];
        int[] zerosRow = new int[m];
        int[] onesCol = new int[n];
        int[] zerosCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    onesRow[i]++;
                else
                    zerosRow[i]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1)
                    onesCol[i]++;
                else
                    zerosCol[i]++;
            }
        }

        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];

        return diff;
    }
}