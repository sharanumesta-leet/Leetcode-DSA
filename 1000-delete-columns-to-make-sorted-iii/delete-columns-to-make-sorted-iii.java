class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int ans = 1;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                boolean isDelete = true;
                for (int k = 0; k < m; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        isDelete = false;
                        break;
                    }
                }
                if (isDelete)
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
            ans = Math.max(ans, lis[i]);
        }
        return n - ans;
    }
}