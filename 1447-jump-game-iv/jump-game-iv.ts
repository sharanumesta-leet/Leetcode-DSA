function minJumps(arr: number[]): number {
    let n = arr.length;
    if (n === 1) return 0;

    let group: Map<number, number[]> = new Map();
    for (let i = 0; i < n; i++) {
        let num = arr[i];
        if (!group.has(num))
            group.set(num, []);
        group.get(num).push(i);
    }

    let visited: Set<number> = new Set();
    visited.add(0);

    let queue: number[] = [0];
    let ans = 0;
    let j = 0;

    while (j < queue.length) {
        let curSize = queue.length - j;
        for (let i = 0; i < curSize; i++) {
            let curIdx = queue[j++];
            let num = arr[curIdx];
            let tempSet: Set<number> = new Set();

            let indices = group.get(num);
            if (indices) {
                indices.forEach((idx) =>
                    tempSet.add(idx)
                );
            }

            let prev = curIdx - 1;
            let next = curIdx + 1;
            if (prev >= 0)
                tempSet.add(prev);
            if (next < n)
                tempSet.add(next);

            for (let num of tempSet) {
                if (num === n - 1) return ans + 1;
                if (!visited.has(num)) {
                    queue.push(num);
                    visited.add(num);
                }
            }
            group.delete(num);
        }
        ans++;
    }

    return 0;
};