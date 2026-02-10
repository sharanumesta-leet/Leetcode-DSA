class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> odd = new HashSet<>();
            Set<Integer> even = new HashSet<>();
            for (int j = i; j < n; j++) {
                int num = nums[j];
                if (num % 2 == 0)
                    even.add(num);
                else
                    odd.add(num);
                if (odd.size() == even.size())
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}