class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[][] sortedNums2 = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums2[i][0] = i;
            sortedNums2[i][1] = nums2[i];
        }
        Arrays.sort(nums1);
        Arrays.sort(sortedNums2, (a, b) -> a[1] - b[1]);
        int j = 0;
        for (int i = 0; i < n; i++) {
            int idx = sortedNums2[j][0];
            int val = sortedNums2[j][1];
            if (nums1[i] > val) {
                ans[idx] = nums1[i];
                j++;
            } else
                list.add(nums1[i]);
        }
        j = 0;
        for (int i = 0; i < n; i++)
            if (ans[i] == -1)
                ans[i] = list.get(j++);
        return ans;
    }
}