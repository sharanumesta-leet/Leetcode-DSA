class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);
        for (int[] op : operations) {
            int fr = op[0];
            int to = op[1];
            int idx = map.get(fr);
            map.remove(fr);
            nums[idx] = to;
            map.put(to, idx);
        }
        return nums;
    }
}