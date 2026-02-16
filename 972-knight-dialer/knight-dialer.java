class Solution {
    static final int MOD = 1_000_000_007;
    int[][] dp;

    public int combinations(Map<Integer, List<Integer>> map, int curNum, int curLen, int n) {
        if (curLen == n)
            return 1;
        if (dp[curNum][curLen] > 0)
            return dp[curNum][curLen];
        int ans = 0;
        for (Integer nextNum : map.get(curNum))
            ans = (ans + combinations(map, nextNum, curLen + 1, n)) % MOD;
        dp[curNum][curLen] = ans;
        return ans;
    }

    public int knightDialer(int n) {
        if (n == 1)
            return 10;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(4, 6)));
        map.put(1, new ArrayList<>(Arrays.asList(6, 8)));
        map.put(2, new ArrayList<>(Arrays.asList(7, 9)));
        map.put(3, new ArrayList<>(Arrays.asList(4, 8)));
        map.put(4, new ArrayList<>(Arrays.asList(0, 3, 9)));
        map.put(5, new ArrayList<>());
        map.put(6, new ArrayList<>(Arrays.asList(0, 1, 7)));
        map.put(7, new ArrayList<>(Arrays.asList(2, 6)));
        map.put(8, new ArrayList<>(Arrays.asList(1, 3)));
        map.put(9, new ArrayList<>(Arrays.asList(2, 4)));

        int ans = 0;
        dp = new int[10][n];
        for (int i = 0; i <= 9; i++)
            if (i != 5)
                ans = (ans + combinations(map, i, 1, n)) % MOD;
        return ans;
    }
}