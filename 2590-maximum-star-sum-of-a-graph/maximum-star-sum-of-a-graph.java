class Solution {
    public List<Integer> topK(List<Integer> neighbors, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer v : neighbors) {
            if (v > 0) {
                pq.offer(v);
                if (pq.size() > k)
                    pq.poll();
            }
        }
        List<Integer> li = new ArrayList<>();
        while (!pq.isEmpty())
            li.add(pq.poll());
        Collections.sort(li, Collections.reverseOrder());
        return li;
    }

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int ans = Integer.MIN_VALUE;
        int n = vals.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(vals[v]);
            graph.get(v).add(vals[u]);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = topK(graph.get(i), k);
            int sum = vals[i];
            for (int val : neighbors) {
                if (val <= 0)
                    break;
                sum += val;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}