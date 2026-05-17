function canReach(arr: number[], start: number): boolean {
    let n: number = arr.length;
    let isVisited: boolean[] = new Array(n).fill(false);

    let queue: number[] = [];
    queue.push(start);
    isVisited[start] = true;

    let i = 0;
    while (i < queue.length) {
        let cur = queue[i++];
        if (arr[cur] === 0) return true;
        let forw = cur + arr[cur];
        let back = cur - arr[cur];
        if (forw < n && !isVisited[forw]) {
            isVisited[forw] = true;
            queue.push(forw);
        }
        if (back >= 0 && !isVisited[back]) {
            isVisited[back] = true;
            queue.push(back);
        }
    }
    return false;
}