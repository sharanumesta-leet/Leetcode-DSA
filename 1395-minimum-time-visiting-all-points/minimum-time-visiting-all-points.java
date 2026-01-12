class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int time = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] p1 = points[i];
            int[] p2 = points[i + 1];
            time += Math.max(Math.abs(p2[0] - p1[0]), Math.abs(p2[1] - p1[1]));
        }
        return time;
    }
}