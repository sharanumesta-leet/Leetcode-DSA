class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        HashSet<Integer> ans = new HashSet<>();
        Set<Integer> times = new TreeSet<>();

        ans.add(0);
        ans.add(firstPerson);

        for (int[] meet : meetings) {
            int p1 = meet[0];
            int p2 = meet[1];
            int t = meet[2];
            if (!map.containsKey(t))
                map.put(t, new ArrayList<>());
            map.get(t).add(new int[] { p1, p2 });
            times.add(t);
        }

        for (int t : times) {
            Set<Integer> start = new HashSet<>();
            Map<Integer, List<Integer>> tempMap = new HashMap<>();
            for (int[] p : map.get(t)) {
                if (!tempMap.containsKey(p[0]))
                    tempMap.put(p[0], new ArrayList<>());
                if (!tempMap.containsKey(p[1]))
                    tempMap.put(p[1], new ArrayList<>());

                tempMap.get(p[0]).add(p[1]);
                tempMap.get(p[1]).add(p[0]);

                if (ans.contains(p[0]))
                    start.add(p[0]);
                if (ans.contains(p[1]))
                    start.add(p[1]);
            }
            Deque<Integer> q = new ArrayDeque<>(start);
            Set<Integer> visited = new HashSet<>(start);
            while (!q.isEmpty()) {
                int p = q.poll();
                for (int person : tempMap.get(p)) {
                    if (!visited.contains(person)) {
                        ans.add(person);
                        q.offer(person);
                        visited.add(person);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}