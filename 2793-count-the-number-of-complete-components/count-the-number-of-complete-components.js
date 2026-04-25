/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var countCompleteComponents = function (n, edges) {
    let ans = 0;
    let graph = new Map();
    for (let i = 0; i < n; i++) graph.set(i, []);
    for (let [u, v] of edges) {
        graph.get(u).push(v);
        graph.get(v).push(u);
    }
    let isVisited = Array(n).fill(false);
    for (let i = 0; i < n; i++) {
        if (!isVisited[i]) {
            let comp = traverse(graph, isVisited, i);
            let totalNode = comp.length;
            let isConnectedComp = true;
            for (let node of comp) {
                if (totalNode - 1 !== graph.get(node).length) {
                    isConnectedComp = false;
                    break;
                }
            }
            if (isConnectedComp) ans++;
        }
    }
    return ans;
};

const traverse = (graph, isVisited, start) => {
    isVisited[start] = true;
    let nodes = [start];
    let queue = [start];
    let i = 0;
    while (i < queue.length) {
        let curNode = queue[i++];
        for (let edge of graph.get(curNode)) {
            if (!isVisited[edge]) {
                isVisited[edge] = true;
                queue.push(edge);
                nodes.push(edge);
            }
        }
    }
    return nodes;
}