import java.util.*;

class Solution {
    private static int xSum(List<int[]> freq, int k, int x) {
        freq.sort((a, b) -> {
            if (b[0] == a[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        int sum = 0;
        for (int i = 0; i < x && i < freq.size(); i++) {
            int f = freq.get(i)[0];
            int num = freq.get(i)[1];
            if (f == 0) break;
            sum += num * f;
        }
        return sum;
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        List<int[]> freq = new ArrayList<>();
        for (int i = 0; i <= 50; i++) freq.add(new int[]{0, i});
        for (int r = 0; r < k; r++) {
            int z = nums[r];
            freq.get(z)[0]++;
        }
        ans[0] = xSum(new ArrayList<>(freq), k, x);
        for (int l = 1, r = k; r < n; l++, r++) {
            int L = nums[l - 1];
            int R = nums[r];
            freq.get(L)[0]--;
            freq.get(R)[0]++;
            ans[l] = xSum(new ArrayList<>(freq), k, x);
        }
        return ans;
    }
}
