class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] nonInc = new int[n];
        int[] nonDec = new int[n];
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (security[i - 1] >= security[i])
                count++;
            else
                count = 0;
            nonInc[i] = count;
        }
        count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1])
                count++;
            else
                count = 0;
            nonDec[i] = count;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (nonInc[i] >= time && nonDec[i] >= time)
                ans.add(i);

        return ans;
    }
}