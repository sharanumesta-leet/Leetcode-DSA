class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int l = 0;
        for (int r = 0; r < prices.length; r++) {
            if (r - l != prices[l] - prices[r])
                l = r;
            ans += (r - l) + 1;
        }
        return ans;
    }
}