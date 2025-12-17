class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Character key : map.keySet())
            pq.offer(new int[] { key, map.get(key) });

        StringBuilder res = new StringBuilder("");
        int[] prev = new int[] { '#', 0 };
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res.append((char) cur[0]);
            if (prev[1] > 0)
                pq.offer(prev);
            cur[1]--;
            prev = cur;
        }
        if (s.length() != res.length())
            return "";
        return res.toString();
    }
}