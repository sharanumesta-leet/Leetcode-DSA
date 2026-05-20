function findThePrefixCommonArray(A: number[], B: number[]): number[] {
    let n = A.length;
    let set: Set<number> = new Set();
    let C: number[] = new Array(n).fill(0);

    let count = 0;
    for (let i = 0; i < n; i++) {
        let n1 = A[i];
        let n2 = B[i];
        if (n1 === n2) {
            C[i] = ++count;
            continue;
        }
        if (set.has(n1)) {
            count++;
            set.delete(n1);
        } else
            set.add(n1);

        if (set.has(n2)) {
            count++;
            set.delete(n2);
        } else
            set.add(n2);
        C[i] = count;
    }
    return C;
};