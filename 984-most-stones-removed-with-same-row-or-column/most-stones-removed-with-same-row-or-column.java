class Solution {
    public void explore(int row, int col, Map<Integer, List<Integer>> rowMap, Map<Integer, List<Integer>> colMap,
            Set<String> isVisited) {
        for (int y : rowMap.getOrDefault(row, new ArrayList<>())) {
            String key = row + "-" + y;
            if (!isVisited.contains(key)) {
                isVisited.add(key);
                explore(row, y, rowMap, colMap, isVisited);
            }
        }
        for (int x : colMap.getOrDefault(col, new ArrayList<>())) {
            String key = x + "-" + col;
            if (!isVisited.contains(key)) {
                isVisited.add(key);
                explore(x, col, rowMap, colMap, isVisited);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int totalStones = stones.length;
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        Set<String> isVisited = new HashSet<>();

        for (int[] point : stones) {
            int x = point[0];
            int y = point[1];
            if (!rowMap.containsKey(x))
                rowMap.put(x, new ArrayList<>());
            if (!colMap.containsKey(y))
                colMap.put(y, new ArrayList<>());
            rowMap.get(x).add(y);
            colMap.get(y).add(x);
        }
        int count = 0;
        for (int[] point : stones) {
            int x = point[0];
            int y = point[1];
            String key = x + "-" + y;
            if (!isVisited.contains(key)) {
                isVisited.add(key);
                explore(x, y, rowMap, colMap, isVisited);
                count++;
            }
        }
        return totalStones - count;
    }
}