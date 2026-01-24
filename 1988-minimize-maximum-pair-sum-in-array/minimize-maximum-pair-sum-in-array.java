class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < (n / 2); i++) {
            int num = nums[i] + nums[n - i - 1];
            ans = Math.max(ans, num);
        }
        return ans;
    }
}