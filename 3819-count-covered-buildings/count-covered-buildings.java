class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        if (buildings.length < 5)
            return 0;
        int INF = Integer.MAX_VALUE;
        int count = 0;
        Map<Integer, int[]> xMap = new HashMap<>();
        Map<Integer, int[]> yMap = new HashMap<>();

        for (int[] loc : buildings) {
            int x = loc[0];
            int y = loc[1];
            if (!xMap.containsKey(x))
                xMap.put(x, new int[] { INF, -INF });
            if (!yMap.containsKey(y))
                yMap.put(y, new int[] { INF, -INF });

            int[] curCol = xMap.get(x);
            curCol[0] = Math.min(curCol[0], y);
            curCol[1] = Math.max(curCol[1], y);

            int[] curRow = yMap.get(y);
            curRow[0] = Math.min(curRow[0], x);
            curRow[1] = Math.max(curRow[1], x);
        }

        for (int[] loc : buildings) {
            int x = loc[0];
            int y = loc[1];
            int[] curCol = xMap.get(x);
            int[] curRow = yMap.get(y);
            if (y > curCol[0] && y < curCol[1] && x > curRow[0] && x < curRow[1])
                count++;
        }
        return count;
    }
}