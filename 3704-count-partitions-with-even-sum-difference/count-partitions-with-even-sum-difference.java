class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        int leftPart = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < n - 1; i++) {
            leftPart += nums[i];
            int rightPart = sum - leftPart;
            if (Math.abs(leftPart - rightPart) % 2 == 0)
                count++;
        }
        return count;
    }
}