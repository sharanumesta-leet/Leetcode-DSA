class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;
        if (m == n)
            return (((m - 1) % MOD) * ((m - 1) % MOD)) % MOD;
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> lengths = new HashSet<>();
        int hLen = hFences.length;
        int vLen = vFences.length;

        for (int i = 0; i < hLen; i++) {
            lengths.add(hFences[i] - 1);
            lengths.add(m - hFences[i]);
            for (int j = i + 1; j < hLen; j++)
                lengths.add(hFences[j] - hFences[i]);
        }
        lengths.add(m - 1);

        long maxLen = -1;
        for (int i = 0; i < vLen; i++) {
            if (lengths.contains(vFences[i] - 1))
                maxLen = Math.max(maxLen, vFences[i] - 1);
            if (lengths.contains(n - vFences[i]))
                maxLen = Math.max(maxLen, n - vFences[i]);
            for (int j = i + 1; j < vLen; j++)
                if (lengths.contains(vFences[j] - vFences[i]))
                    maxLen = Math.max(maxLen, vFences[j] - vFences[i]);
        }
        if (lengths.contains(n - 1))
            maxLen = Math.max(maxLen, n - 1);

        return maxLen == -1 ? -1 : (int) (((long) maxLen * maxLen) % MOD);
    }
}