class Solution {
    public int firstMissingPositive(int[] nums) {
        int idx = 0;
        for (int num : nums)
            if (num > 0)
                nums[idx++] = num;

        for (int i = 0; i < idx; i++)
            if (Math.abs(nums[i]) <= idx && nums[Math.abs(nums[i]) - 1] > 0)
                nums[Math.abs(nums[i]) - 1] *= -1;

        for (int i = 0; i < idx; i++)
            if (nums[i] > 0)
                return i + 1;
        return idx + 1;
    }
}