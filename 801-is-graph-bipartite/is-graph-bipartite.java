class Solution {
    public boolean bfs(int[][] graph, int node, int[] paint) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(node);
        paint[node] = 0;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            for (int neig : graph[curNode]) {
                if (paint[neig] == -1) {
                    paint[neig] = (paint[curNode] + 1) % 2;
                    q.offer(neig);
                } else if (paint[neig] == paint[curNode])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] paint = new int[n];
        Arrays.fill(paint, -1);

        for (int i = 0; i < n; i++) {
            if (paint[i] == -1) {
                boolean isBi = bfs(graph, i, paint);
                if (!isBi)
                    return false;
            }
        }
        return true;
    }
}