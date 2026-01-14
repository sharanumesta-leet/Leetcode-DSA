class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n = operations.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int ch1 = operations[i].charAt(0);
            int ch2 = operations[i].charAt(2);
            count += ch1 == '+' ? 1 : ch1 == '-' ? -1 : 0;
            count += ch2 == '+' ? 1 : ch2 == '-' ? -1 : 0;
        }
        return count;
    }
}