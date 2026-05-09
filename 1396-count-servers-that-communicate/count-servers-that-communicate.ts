/**
 * @param {number[][]} grid
 * @return {number}
 */
var countServers = function (grid) {
    let m = grid.length;
    let n = grid[0].length;
    let rowMap = new Map();
    let colMap = new Map();
    let totalServer = 0;
    let isolated = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j]) {
                totalServer++;
                if (!rowMap.has(i)) rowMap.set(i, []);
                if (!colMap.has(j)) colMap.set(j, []);
                rowMap.get(i).push(j);
                colMap.get(j).push(i);
            }
        }
    }
    for (let row of rowMap.keys()) {
        if ((rowMap.get(row).length === 1) && (colMap.get(rowMap.get(row)[0]).length === 1)) isolated++;
    }
    return totalServer - isolated;
};