function closedIsland(grid: number[][]): number {
    let m: number = grid.length; // row
    let n: number = grid[0].length; // col
    let ans: number = 0;
    let visited: boolean[][] = Array.from({ length: m }, () => new Array(n).fill(false));

    let dir: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    const island = (i: number, j: number) => {
        visited[i][j] = true;
        for (let [x, y] of dir) {
            let nRow = i + x;
            let nCol = j + y;
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] === 0 && !visited[nRow][nCol])
                island(nRow, nCol);
        }
    }

    for (let i = 0; i < m; i++) {
        if (grid[i][0] === 0 && !visited[i][0])
            island(i, 0);
        if (grid[i][n - 1] === 0 && !visited[i][n - 1])
            island(i, n - 1);
    }

    for (let i = 1; i < n - 1; i++) {
        if (grid[0][i] === 0 && !visited[0][i])
            island(0, i);
        if (grid[m - 1][i] === 0 && !visited[m - 1][i])
            island(m - 1, i);
    }

    for (let i = 1; i < m - 1; i++) {
        for (let j = 1; j < n - 1; j++) {
            if (grid[i][j] === 0 && !visited[i][j]) {
                island(i, j);
                ans++;
            }
        }
    }

    return ans;
};
