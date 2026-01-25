class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = arr.length;
        int m = mat.length;
        int n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }

        for (int i = 0; i < len; i++) {
            int num = arr[i];
            int[] pos = map.get(num);
            int numRow = pos[0];
            int numCol = pos[1];

            rows[numRow]++;
            cols[numCol]++;
            if (rows[numRow] == n || cols[numCol] == m)
                return i;
        }
        return 0;
    }
}