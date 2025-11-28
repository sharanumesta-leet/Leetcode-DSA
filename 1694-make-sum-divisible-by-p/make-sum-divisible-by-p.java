class Solution {
    public int minSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        int n = nums.length;
        int len = n;

        for (int num : nums)
            sum += num;

        int target = (int)(sum % k);
        if (target == 0)
            return 0;

        int curSum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            curSum = (curSum + nums[i]) % k;
            int reqSum = ((curSum - target) + k) % k;
            if (map.containsKey(reqSum))
                len = Math.min(len, i - map.get(reqSum));
            map.put(curSum, i);
        }
        return len == n ? -1 : len;
    }
}