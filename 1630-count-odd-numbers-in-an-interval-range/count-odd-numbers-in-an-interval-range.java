class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        low += (low % 2 == 0) ? 1 : 0;
        for (int i = low; i <= high; i += 2)
            count++;
        return count;
    }
}