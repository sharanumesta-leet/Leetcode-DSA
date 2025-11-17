class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Long, Long> map = new HashMap<>();
        int n = tasks.length;
        long days = 0L;
        for (long t : tasks) {
            if (map.containsKey(t)) {
                Long last = map.get(t);
                if (days - last <= space)
                    days = last + space + 1;
            }
            map.put(t, days);
            days++;
        }
        return days;
    }
}