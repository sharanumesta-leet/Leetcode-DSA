class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        boolean[] arr = new boolean[n];
        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (count >= k)
                arr[i] = true;
            count = (nums[i] <= nums[i + 1]) ? count + 1 : 1;
        }
        count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] && count >= k)
                ans.add(i);
            count = (nums[i - 1] >= nums[i]) ? count + 1 : 1;
        }
        return ans;
    }
}