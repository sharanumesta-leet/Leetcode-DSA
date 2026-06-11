function assignEdgeWeights(edges: number[][]): number {
    const tree = new Map<number, number[]>();
    const children = new Set<number>();

    for (const [u, v] of edges) {
        if (!tree.has(u)) tree.set(u, []);
        tree.get(u)!.push(v);
        children.add(v);
    }

    let root = -1;

    for (const [u] of edges) {
        if (!children.has(u)) {
            root = u;
            break;
        }
    }

    const depth = maxDepth(root, tree);

    return modPow(2, depth - 1, 1000000007);
}

const maxDepth = (node: number, tree: Map<number, number[]>): number => {
    if (!tree.has(node)) return 0;

    let child: number[] = tree.get(node)!;
    let best = 0;

    for (let c of child)
        best = Math.max(best, maxDepth(c, tree));

    return best + 1;
}

function modPow(base: number, exp: number, mod: number): number {
    let result = 1n;
    let b = BigInt(base);
    let e = BigInt(exp);
    const m = BigInt(mod);

    while (e > 0n) {
        if (e & 1n) {
            result = (result * b) % m;
        }
        b = (b * b) % m;
        e >>= 1n;
    }

    return Number(result);
}