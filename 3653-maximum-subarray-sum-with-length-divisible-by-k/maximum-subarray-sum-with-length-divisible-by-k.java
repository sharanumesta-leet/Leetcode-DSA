class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        long prefixSum = 0;
        long[] minPrefixSum = new long[k];
        Arrays.fill(minPrefixSum, Long.MAX_VALUE / 2);
        minPrefixSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int idx = i % k;
            ans = Math.max(ans, prefixSum - minPrefixSum[idx]);
            minPrefixSum[idx] = Math.min(minPrefixSum[idx], prefixSum);
        }
        return ans;
    }
}