function highestPeak(isWater: number[][]): number[][] {
    let m = isWater.length;
    let n = isWater[0].length;

    let ans: number[][] = new Array(m)
        .fill(0)
        .map(() => new Array(n).fill(-1));

    let dir: number[][] = [
        [-1, 0],
        [0, 1],
        [1, 0],
        [0, -1]
    ];

    let queue: number[][] = [];
    let head = 0;

    // Add all water cells to the queue
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (isWater[i][j] === 1) {
                ans[i][j] = 0;
                queue.push([i, j]);
            }
        }
    }

    // Multi-source BFS
    while (head < queue.length) {
        let [i, j] = queue[head++];

        for (let [x, y] of dir) {
            let r = i + x;
            let c = j + y;

            if (
                r >= 0 &&
                c >= 0 &&
                r < m &&
                c < n &&
                ans[r][c] === -1
            ) {
                ans[r][c] = ans[i][j] + 1;
                queue.push([r, c]);
            }
        }
    }

    return ans;
}