class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = 0;

        int oneWeek = 28;
        for (int week = 0; week < weeks; week++)
            total += oneWeek + (week * 7);

        for (int day = 1; day <= days; day++)
            total += day + weeks;

        return total;
    }
}