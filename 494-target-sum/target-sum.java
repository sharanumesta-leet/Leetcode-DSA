class Solution {
    public int numOfExpression(int[] nums, int i, int sum, int target) {
        if (i == nums.length)
            return sum == target ? 1 : 0;
        return numOfExpression(nums, i + 1, sum + nums[i], target) + numOfExpression(nums, i + 1, sum - nums[i], target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return numOfExpression(nums, 0, 0, target);
    }
}