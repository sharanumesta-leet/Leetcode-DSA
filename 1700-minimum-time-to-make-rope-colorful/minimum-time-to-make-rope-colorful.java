class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] chars = colors.toCharArray();
        int n = colors.length();
        int time = 0;
        int l = 0;
        for (int r = 1; r < n; r++) {
            if (chars[l] == chars[r]) {
                time += Math.min(neededTime[l], neededTime[r]);
                if (neededTime[l] < neededTime[r])
                    l = r;
            } else
                l = r;
        }
        return time;
    }
}