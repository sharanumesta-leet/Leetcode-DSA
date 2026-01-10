class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int b = s2.charAt(j - 1);
                if (a == b)
                    dp[i][j] = dp[i - 1][j - 1] + a;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int totalSum = 0;
        for (int ch : s1.toCharArray())
            totalSum += ch;
        for (int ch : s2.toCharArray())
            totalSum += ch;
        return totalSum - (2 * dp[m][n]);
    }
}