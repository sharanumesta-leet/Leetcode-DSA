class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        long count = 0;
        int n = nums.length;
        Map<Integer, Integer> map_left = new HashMap<>();
        Map<Integer, Integer> map_right = new HashMap<>();

        map_left.put(nums[0], 1);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            map_right.put(num, map_right.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i < n - 1; i++) {
            int num = nums[i];
            int target = num * 2;
            map_right.put(num, map_right.get(num) - 1);
            int right = map_right.getOrDefault(target, 0);
            int left = map_left.getOrDefault(target, 0);
            count = (count + (long) left * (long) right) % MOD;
            map_left.put(num, map_left.getOrDefault(num, 0) + 1);
        }
        return (int) count;
    }
}