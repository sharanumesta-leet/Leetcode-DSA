class Solution {
    Map<Integer, Queue<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num))
                map.put(num, new LinkedList<>());
            map.get(num).offer(i);
        }
    }

    public int pick(int target) {
        int idx = map.get(target).poll();
        map.get(target).offer(idx);
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */