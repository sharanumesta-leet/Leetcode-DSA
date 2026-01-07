class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            int localMax = 0;
            Map<Double, Integer> slope = new HashMap<>();
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                double m = Double.MAX_VALUE;
                if (p1[0] != p2[0])
                    m = (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
                if (Math.abs(m) == 0.0)
                    m = 0.0;
                slope.put(m, slope.getOrDefault(m, 0) + 1);
                localMax = Math.max(localMax, slope.get(m));
            }
            ans = Math.max(ans, localMax + 1);
        }
        return ans;
    }
}