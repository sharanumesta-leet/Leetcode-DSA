class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;
        int n = stones.length;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i < n; i++)
            map.put(stones[i], new HashSet<>());
        map.get(1).add(1);

        for (int i = 1; i < n; i++) {
            int pos = stones[i];
            for (Integer jump : map.get(pos)) {
                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
                    int nextPos = pos + nextJump;
                    if (nextJump > 0 && map.containsKey(nextPos)) {
                        map.get(nextPos).add(nextJump);
                    }
                }
            }
        }
        return map.get(stones[n - 1]).size() > 0;
    }
}