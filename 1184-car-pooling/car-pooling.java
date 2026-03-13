class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[][] pickup = new int[n][2];
        int[][] drop = new int[n][2];
        for (int i = 0; i < n; i++) {
            pickup[i][0] = trips[i][0];
            drop[i][0] = trips[i][0];
            pickup[i][1] = trips[i][1];
            drop[i][1] = trips[i][2];
        }
        Arrays.sort(pickup, (a, b) -> a[1] - b[1]);
        Arrays.sort(drop, (a, b) -> a[1] - b[1]);
        int curPassengers = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && pickup[j][1] < drop[i][1])
                curPassengers += pickup[j++][0];
            if (curPassengers > capacity)
                return false;
            curPassengers -= drop[i][0];
        }
        return true;
    }
}