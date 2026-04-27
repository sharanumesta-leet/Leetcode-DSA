/**
 * @param {number[][]} grid
 * @return {boolean}
 */
var hasValidPath = function (grid) {
    let dir = [[0, -1], [-1, 0], [0, 1], [1, 0]]; // left top right bottom
    let street = [[0, 2], [1, 3], [0, 3], [2, 3], [0, 1], [1, 2]];
    const opp = {
        0: 2,
        2: 0,
        1: 3,
        3: 1
    }
    return dfs(0, 0, grid, street, dir, opp);
};

const dfs = (i, j, grid, street, dir, opp) => {
    let m = grid.length;
    let n = grid[0].length;

    if (i === m - 1 && j === n - 1) return true;
    
    let streetNo = grid[i][j];
    grid[i][j] = -1;

    for (let next of street[streetNo - 1]) {
        let x = dir[next][0] + i;
        let y = dir[next][1] + j;
        if (x < 0 || y < 0 || x >= m || y >= n) continue;

        let nextCell = grid[x][y];
        if (nextCell === -1) continue;

        let nextOpts = street[nextCell - 1];
        let req = opp[next];
        if (nextOpts.includes(req))
            if (dfs(x, y, grid, street, dir, opp)) return true;

    }
    return false;
}