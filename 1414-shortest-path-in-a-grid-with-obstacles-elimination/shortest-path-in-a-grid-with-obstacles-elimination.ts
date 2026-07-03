function shortestPath(grid: number[][], k: number): number {
    let m = grid.length;
    let n = grid[0].length;

    let dir = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    let q: number[][] = [];

    let best = Array.from({ length: m }, () => Array(n).fill(-1));

    q.push([0, 0, k]);
    best[0][0] = k;

    let path = 0;
    let idx = 0;

    while (idx < q.length) {
        let curLen = q.length;

        for (let i = idx; i < curLen; i++) {
            let [x, y, r] = q[idx++];

            if (x === m - 1 && y === n - 1)
                return path;

            for (let [dx, dy] of dir) {
                let nr = x + dx;
                let nc = y + dy;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    let rem = r - grid[nr][nc];

                    if (rem >= 0 && rem > best[nr][nc]) {
                        best[nr][nc] = rem;
                        q.push([nr, nc, rem]);
                    }
                }
            }
        }

        path++;
    }

    return -1;
}