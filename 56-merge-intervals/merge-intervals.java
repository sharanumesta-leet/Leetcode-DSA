class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        merged.add(new int[] { intervals[0][0], intervals[0][1] });
        for (int i = 1; i < n; i++) {
            if (merged.get(merged.size() - 1)[1] >= intervals[i][0])
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], intervals[i][1]);
            else
                merged.add(new int[] { intervals[i][0], intervals[i][1] });
        }
        int m = merged.size();
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            ans[i][0] = merged.get(i)[0];
            ans[i][1] = merged.get(i)[1];
        }
        return ans;
    }
}