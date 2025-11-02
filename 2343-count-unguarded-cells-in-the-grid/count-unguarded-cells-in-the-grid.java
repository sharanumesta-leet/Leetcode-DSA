class Solution {
    public void watch(char[][] grid, int x, int y, int row, int col, int m, int n) {
        while (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] != 'W' && grid[row][col] != 'G') {
            grid[row][col] = 'g';
            row += x;
            col += y;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = 'O';

        for (int[] guard : guards)
            grid[guard[0]][guard[1]] = 'G';

        for (int[] wall : walls)
            grid[wall[0]][wall[1]] = 'W';

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            for (int[] dir : directions) {
                int x = dir[0];
                int y = dir[1];
                watch(grid, x, y, row + x, col + y, m, n);
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 'O')
                    result++;
        return result;
    }
}