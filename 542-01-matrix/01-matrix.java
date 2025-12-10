class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> q = new ArrayDeque<>();
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0)
                    q.offer(new int[] { i, j });
                else
                    mat[i][j] = -1;
            }
        }
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int dist = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cell = q.poll();
                for (int[] d : dir) {
                    int nextRow = cell[0] + d[0];
                    int nextCol = cell[1] + d[1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && mat[nextRow][nextCol] == -1) {
                        mat[nextRow][nextCol] = dist;
                        q.offer(new int[] { nextRow, nextCol });
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}