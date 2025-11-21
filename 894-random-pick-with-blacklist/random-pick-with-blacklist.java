class Solution {
    Map<Integer, Integer> map;
    int range;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        for (int num : blacklist)
            map.put(num, -1);

        range = n - blacklist.length;
        int num = range;

        for (int b : blacklist) {
            if (b < range) {
                while (map.containsKey(num))
                    num++;
                map.put(b, num++);
            }
        }
    }

    public int pick() {
        int num = new Random().nextInt(range);
        return map.containsKey(num) ? map.get(num) : num;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */