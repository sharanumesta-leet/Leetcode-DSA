class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] bk : bookings) {
            int first = bk[0];
            int last = bk[1];
            int seat = bk[2];
            ans[first - 1] += seat;
            if (last != n)
                ans[last] -= seat;
        }
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += ans[i];
            ans[i] = preSum;
        }
        return ans;
    }
}