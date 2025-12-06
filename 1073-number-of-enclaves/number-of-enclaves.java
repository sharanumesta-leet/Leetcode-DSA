class Solution {
    public void dfs(int row, int col, int[][] grid, int[][] dir, int n, int m) {
        if (grid[row][col] == 1)
            grid[row][col] = 0;
        for (int[] d : dir) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && grid[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol, grid, dir, n, m);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1)
                dfs(i, 0, grid, dir, n, m);
            if (grid[i][m - 1] == 1)
                dfs(i, m - 1, grid, dir, n, m);
        }
        for (int j = 1; j < m - 1; j++) {
            if (grid[0][j] == 1)
                dfs(0, j, grid, dir, n, m);
            if (grid[n - 1][j] == 1)
                dfs(n - 1, j, grid, dir, n, m);
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++)
            for (int j = 1; j < m - 1; j++)
                if (grid[i][j] == 1)
                    count++;
        return count;
    }
}