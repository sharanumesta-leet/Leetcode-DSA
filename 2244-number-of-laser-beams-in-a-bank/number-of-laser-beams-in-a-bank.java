class Solution {
    public int countOnes(String num) {
        int count = 0;
        for (char ch : num.toCharArray())
            if (ch == '1')
                count++;
        return count;
    }

    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int res = 0;
        int prev = countOnes(bank[0]);
        for (int i = 1; i < n; i++) {
            int cur = countOnes(bank[i]);
            if (cur > 0) {
                res += (prev * cur);
                prev = cur;
            }
        }
        return res;
    }
}