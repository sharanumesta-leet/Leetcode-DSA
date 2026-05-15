class Solution {
    public static class Pair {
        int act;
        int min;
        int diff;

        public Pair(int act, int min, int diff) {
            this.act = act;
            this.min = min;
            this.diff = diff;
        }
    }

    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff == b.diff)
                return b.min - a.min;
            return b.diff - a.diff;
        });
        for (int i = 0; i < n; i++) {
            int[] task = tasks[i];
            int act = task[0];
            int min = task[1];
            int diff = min - act;
            pq.offer(new Pair(act, min, diff));
        }
        Pair fTask = pq.poll();
        int energy = fTask.min;
        int curEnergy = energy - fTask.act;
        while (!pq.isEmpty()) {
            Pair curTask = pq.poll();
            if (curEnergy < curTask.min) {
                int req = curTask.min - curEnergy;
                energy += req;
                curEnergy += req;
            }
            curEnergy -= curTask.act;
        }
        return energy;
    }
}