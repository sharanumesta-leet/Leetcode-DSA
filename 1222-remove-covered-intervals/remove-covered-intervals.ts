function removeCoveredIntervals(intervals: number[][]): number {
    intervals.sort((a, b) => {
        if (a[0] === b[0])
            return b[1] - a[1];
        return a[0] - b[0];
    });
    let n = intervals.length;

    let count = 0;
    let last: number[] = intervals[0];
    for (let i = 1; i < n; i++) {
        let cur: number[] = intervals[i];
        if (last[1] >= cur[1]) {
            count++;
        } else {
            last = cur;
        }
    }
    return n - count;
};