class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int inf = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // (node, time, fees)
        pq.offer(new int[] { 0, 0, passingFees[0] });

        int[] minTime = new int[n];
        Arrays.fill(minTime, inf);
        minTime[0] = 0;

        List<List<int[]>> edge = new ArrayList<>();
        for (int i = 0; i < n; i++)
            edge.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = e[2];
            edge.get(u).add(new int[] { v, t });
            edge.get(v).add(new int[] { u, t });
        }

        while (!pq.isEmpty()) {
            int[] node = pq.poll(); //  (node, time, fees)
            int u = node[0];
            int t = node[1];
            int f = node[2];
            if (u == n - 1)
                return f;
            List<int[]> neig = edge.get(u);
            for (int i = 0; i < neig.size(); i++) {
                int neigV = neig.get(i)[0];
                int neigT = neig.get(i)[1];
                int curTime = t + neigT;
                int curFees = f + passingFees[neigV];
                if (curTime <= maxTime && curTime < minTime[neigV]) {
                    minTime[neigV] = curTime;
                    pq.offer(new int[] { neigV, curTime, curFees });
                }
            }
        }
        return -1;
    }
}