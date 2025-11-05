class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        map.forEach((a, b) -> {
            pq.offer(new int[] { a, b });
            if (pq.size() > k)
                pq.poll();
        });
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty())
            res[i++] = pq.poll()[0];
        return res;
    }
}