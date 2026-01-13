class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple)
            totalApples += a;

        int curCapacity = 0;
        Arrays.sort(capacity);

        for (int i = 0, j = capacity.length - 1; i < j; i++, j--) {
            int temp = capacity[i];
            capacity[i] = capacity[j];
            capacity[j] = temp;
        }

        int i;
        for (i = 0; i < capacity.length; i++) {
            curCapacity += capacity[i];
            if (totalApples <= curCapacity)
                break;
        }
        return i+1;
    }
}