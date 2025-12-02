class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1_000_000_007;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pt : points) {
            int y = pt[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        long totalPts = 0;
        for (Integer key : map.keySet()) {
            long n = map.get(key);
            if (n > 1) {
                long curCombination = (n * (n - 1)) / 2;
                ans = (ans + curCombination * totalPts) % MOD;
                totalPts = (totalPts + curCombination) % MOD;
            }
        }
        return (int)(ans % MOD);
    }
}