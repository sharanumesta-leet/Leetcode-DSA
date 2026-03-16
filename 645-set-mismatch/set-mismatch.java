class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = nums[0];
        int dup = -1;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if (dup == -1 && nums[i - 1] == nums[i])
                dup = nums[i];
        }
        int totalSum = (n * (n + 1)) / 2;
        return new int[]{dup, totalSum - sum + dup};
    }
}