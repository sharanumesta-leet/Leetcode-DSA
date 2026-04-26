/**
 * @param {character[][]} grid
 * @return {boolean}
 */
var containsCycle = function (grid) {
    let n = grid.length;
    let m = grid[0].length;
    let isVisited = Array.from({ length: n }, () => new Array(m).fill(false));

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (!isVisited[i][j]) {
                if (dfs(grid[i][j], i, j, -1, -1, n, m, grid, isVisited))
                    return true;
            }
        }
    }
    return false;
};

const dfs = (ch, i, j, a, b, n, m, grid, isVisited) => {
    isVisited[i][j] = true;
    let dir = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    for (let [dx, dy] of dir) {
        let nextRow = i + dx;
        let nextCol = j + dy;
        if ((nextRow === a && nextCol === b) || nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
        if (grid[nextRow][nextCol] === ch) {
            if (isVisited[nextRow][nextCol]) return true;
            if (dfs(grid[nextRow][nextCol], nextRow, nextCol, i, j, n, m, grid, isVisited)) return true;
        }
    }
    return false;
}