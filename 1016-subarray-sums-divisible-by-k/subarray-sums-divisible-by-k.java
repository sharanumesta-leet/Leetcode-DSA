class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int preSum = 0;
        int[] subCount = new int[k];
        Arrays.fill(subCount, 0);
        subCount[0] = 1;
        for (int num : nums) {
            preSum += num;
            int rem = preSum % k;
            rem += rem < 0 ? k : 0;
            res += subCount[rem];
            subCount[rem]++;
        }
        return res;
    }
}