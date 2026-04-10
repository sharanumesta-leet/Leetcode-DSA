class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return -1;
        int ans = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (!map.containsKey(num))
                map.put(num, new ArrayList<>());
            map.get(num).add(i);
        }
        for (int key : map.keySet()) {
            if (map.get(key).size() >= 3) {
                for (int i = 1; i < map.get(key).size() - 1; i++) {
                    int a = map.get(key).get(i - 1);
                    int b = map.get(key).get(i);
                    int c = map.get(key).get(i + 1);
                    int curDist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    ans = Math.min(ans, curDist);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}