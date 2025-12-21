class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int n = strs.length;
        int count = 0;
        boolean[] isSorted = new boolean[n - 1];
        int sortCount = 0;

        for (int i = 0; i < m; i++) {
            List<Integer> markSorted = new ArrayList<>();
            boolean isValidCol = true;
            for (int j = 0; j < n - 1; j++) {
                if (!isSorted[j]) {
                    if (strs[j].charAt(i) < strs[j + 1].charAt(i)) {
                        markSorted.add(j);
                    } else if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                        isValidCol = false;
                        count++;
                        break;
                    }
                }
            }
            if (isValidCol)
                for (int l : markSorted) {
                    isSorted[l] = true;
                    sortCount++;
                }
            if (sortCount == n - 1)
                break;
        }
        return count;
    }
}