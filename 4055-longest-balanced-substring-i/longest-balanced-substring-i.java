class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                Set<Integer> set = new HashSet<>();
                for (int num : freq)
                    if (num > 0)
                        set.add(num);
                if (set.size() == 1)
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}