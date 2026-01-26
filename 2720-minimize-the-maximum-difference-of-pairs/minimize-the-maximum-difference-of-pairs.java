class Solution {
    public boolean isValidPairs(int[] nums, int maxDif, int p) {
        int count = 0;
        int i = 1;
        while (i < nums.length) {
            int dif = nums[i] - nums[i - 1];
            if (dif <= maxDif) {
                count++;
                i += 2;
            } else
                i++;
            if (count >= p)
                return true;
        }
        return false;
    }

    public int minimizeMax(int[] nums, int p) {
        if (p == 0)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = nums[n - 1] - nums[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (isValidPairs(nums, mid, p)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}