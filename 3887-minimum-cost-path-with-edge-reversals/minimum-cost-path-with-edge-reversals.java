class Solution {
    public int minCost(int n, int[][] edges) {
        int inf = Integer.MAX_VALUE;
        List<List<int[]>> edge = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, inf);
        dist[0] = 0;
        pq.offer(new int[] { 0, 0 });

        for (int i = 0; i < n; i++)
            edge.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            edge.get(u).add(new int[] { v, w });
            edge.get(v).add(new int[] { u, w * 2 });
        }

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int w = node[1];
            if (dist[u] < w)
                continue;
            List<int[]> neig = edge.get(u);
            for (int i = 0; i < neig.size(); i++) {
                int neigV = neig.get(i)[0];
                int neigW = neig.get(i)[1];
                int curDist = w + neigW;
                if (dist[neigV] > curDist) {
                    dist[neigV] = curDist;
                    pq.offer(new int[] { neigV, curDist });
                }
            }
        }

        return dist[n - 1] == inf ? -1 : dist[n - 1];
    }
}