class Solution {
    public boolean isValidTime(long time, int n, int[] batteries) {
        long sum = 0;
        for (int bt : batteries)
            sum += Math.min(time, bt);
        return sum >= (long)(n * time);
    }

    public long binarySearch(long low, long high, int[] batteries, int n) {
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isValidTime(mid, n, batteries)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int bt : batteries)
            sum +=  bt;
        return binarySearch(0, sum / n, batteries, n);
    }
}