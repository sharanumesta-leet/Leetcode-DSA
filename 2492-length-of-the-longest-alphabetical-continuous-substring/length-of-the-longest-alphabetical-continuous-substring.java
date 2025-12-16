class Solution {
    public int longestContinuousSubstring(String s) {
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (r - l != s.charAt(r) - s.charAt(l))
                l = r;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}