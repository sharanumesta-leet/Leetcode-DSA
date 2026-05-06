function rotateTheBox(boxGrid: string[][]): string[][] {
    let m = boxGrid.length;
    let n = boxGrid[0].length;

    let ans: string[][] = Array.from({ length: n }, () => Array(m));

    // Trsnspose
    for (let i = 0; i < m; i++)
        for (let j = 0; j < n; j++)
            ans[j][i] = boxGrid[i][j];

    // Row reverse
    for (let i = 0; i < n; i++)
        for (let j = 0; j < Math.floor(m / 2); j++)
            [ans[i][j], ans[i][m - j - 1]] = [ans[i][m - j - 1], ans[i][j]];

    // Apply gravity
    for (let i = 0; i < m; i++) { // col
        let empty = n - 1;
        while (empty >= 0 && ans[empty][i] !== ".") empty--;
        let j = empty - 1;
        while (j >= 0) {
            if (ans[j][i] === "#") {
                [ans[j][i], ans[empty][i]] = [ans[empty][i], ans[j][i]];
                empty--;
            } else if (ans[j][i] === "*") {
                while ((j >= 0) && (ans[j][i] !== ".")) j--;
                empty = j;
            }
            j--;
        }
    }
    return ans;
};