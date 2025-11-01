class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = 0;
        rightSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            rightSum[n - i - 1] = rightSum[n - i] + nums[n - i];
        }
        for (int i = 0; i < n; i++) {
            result[i] = ((nums[i] * (i)) - leftSum[i]) + (rightSum[i] - ((n - i - 1) * nums[i]));
        }
        return result;
    }
}