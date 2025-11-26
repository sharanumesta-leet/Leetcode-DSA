class Solution {
    public int dfs(int[][] grid, int i, int j, int n, int m, int k, int[][] dir, int rem, int[][][] dp, boolean[][][] vis) {
        int MOD = 1000_000_007;
        int count = 0;
        int curRem = (rem + grid[i][j]) % k;

        if (vis[i][j][curRem])
            return dp[i][j][curRem];

        if (i == n - 1 && j == m - 1) {
            if (curRem == 0)
                count = 1;
            return count % MOD;
        }
        for (int[] d : dir) {
            int nextRow = i + d[0];
            int nextCol = j + d[1];
            if (nextRow < n && nextCol < m)
                count = (count +  dfs(grid, nextRow, nextCol, n, m, k, dir, curRem, dp, vis)) % MOD;
        }
        vis[i][j][curRem] = true;
        dp[i][j][curRem] = count % MOD;
        return dp[i][j][curRem];
    }

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        boolean[][][] vis = new boolean[n][m][k];
        int[][] dir = { { 0, 1 }, { 1, 0 } };
        return dfs(grid, 0, 0, n, m, k, dir, 0, dp, vis);
    }
}