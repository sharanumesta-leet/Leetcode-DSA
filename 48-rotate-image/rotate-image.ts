/**
 Do not return anything, modify matrix in-place instead.
 */
function rotate(matrix: number[][]): void {
    let n: number = matrix.length;
    for (let i = 0; i < n; i++)
        for (let j = i + 1; j < n; j++)
            [matrix[j][i], matrix[i][j]] = [matrix[i][j], matrix[j][i]];

    for (let i = 0; i < n; i++)
        for (let j = 0; j < Math.floor(n / 2); j++)
            [matrix[i][n - j - 1], matrix[i][j]] = [matrix[i][j], matrix[i][n - j - 1]];
};