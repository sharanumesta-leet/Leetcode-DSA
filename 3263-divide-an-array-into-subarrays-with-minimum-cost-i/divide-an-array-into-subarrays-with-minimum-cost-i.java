class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        nums[0] = 100;
        Arrays.sort(nums);
        ans += nums[0] + nums[1];
        return ans;
    }
}