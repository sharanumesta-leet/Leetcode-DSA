class Solution {
    public int countValidSelections(int[] nums) {
        int result = 0;
        int n = nums.length;
        int[] preSum = new int[n];
        int[] postSum = new int[n];
        preSum[0] = 0;
        postSum[n - 1] = 0;
        for (int i = 1; i < n; i++)
            preSum[i] = nums[i - 1] + preSum[i - 1];
        for (int i = n - 2; i >= 0; i--)
            postSum[i] = nums[i + 1] + postSum[i + 1];

        for (int i = 0; i < n ; i++) {
            if (nums[i] == 0) {
                int diff = Math.abs(preSum[i] - postSum[i]);
                if (diff == 0)
                    result += 2;
                else if (diff == 1)
                    result += 1;
            }
        }
        return result;
    }
}