function canReach(s: string, minJump: number, maxJump: number): boolean {
    let arr: string[] = s.split("");
    let n: number = arr.length;
    if (arr[n - 1] === '1')
        return false;

    let queue: number[] = [];
    queue.push(0);

    let isVisited: boolean[] = new Array(n).fill(false);
    isVisited[0] = true;

    let farthest: number = 0;
    let idx = 0;
    while (idx < queue.length) {
        let cur = queue[idx++];
        let start: number = Math.max(cur + minJump, farthest + 1);
        let end: number = Math.min(cur + maxJump, n - 1);
        for (let next = start; next <= end; next++) {
            if (!isVisited[next] && arr[next] === '0') {
                if (next === n - 1)
                    return true;
                isVisited[next] = true;
                queue.push(next);
            }
        }
        farthest = end;
    }
    return false;
};