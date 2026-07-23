/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
var shiftGrid = function(grid, k) {
    const m = grid.length;
    const n = grid[0].length;

    const total = m * n;
    k %= total;

    const ans = Array.from({ length: m }, () => Array(n).fill(0));

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {

            // Index in 1D array (before rotation)
            const oldIndex = i * n + j;

            // Index in 1D array (after rotation)
            const newIndex = (oldIndex + k) % total;

            // Convert 1D index back to 2D
            const newRow = Math.floor(newIndex / n);
            const newCol = newIndex % n;

            ans[newRow][newCol] = grid[i][j];
        }
    }

    return ans;
};