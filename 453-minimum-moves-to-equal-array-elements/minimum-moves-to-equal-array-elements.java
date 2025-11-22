class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int min = nums[0];
        for (int num : nums)
            ans += num - min;
        return ans;
    }
}