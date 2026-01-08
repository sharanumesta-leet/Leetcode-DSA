class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        long minVal = Long.MIN_VALUE;

        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], minVal);

        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];
                long prod = (long) num1 * num2;
                long cntn = prod + (dp[i - 1][j - 1] == minVal ? 0 : dp[i - 1][j - 1]);
                dp[i][j] = Math.max((int) cntn, Math.max(dp[i][j - 1], Math.max(prod, dp[i - 1][j])));
            }
        }
        return (int) dp[m][n];
    }
}