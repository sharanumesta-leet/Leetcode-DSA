class Solution {
    public boolean canReduceHeight(long sec, int[] workerTimes, int mountainHeight) {
        long totalHeight = 0;
        for (int w : workerTimes) {
            long h = (long) ((Math.sqrt(1 + 8.0 * sec / w) - 1) / 2);
            totalHeight += h;
            if (totalHeight >= mountainHeight)
                return true;
        }
        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = (long) 1e18;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canReduceHeight(mid, workerTimes, mountainHeight)) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return ans;
    }
}