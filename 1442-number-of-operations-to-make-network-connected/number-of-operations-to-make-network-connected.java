class Solution {
    public void explore(int node, boolean[] isVisited, Map<Integer, List<Integer>> adj) {
        isVisited[node] = true;
        for (int neig : adj.get(node))
            if (!isVisited[neig])
                explore(neig, isVisited, adj);
    }

    public int makeConnected(int n, int[][] connections) {
        int wires = connections.length;
        if (wires < n - 1)
            return -1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                explore(i, isVisited, adj);
                components++;
            }
        }
        return components - 1;
    }
}