class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            ans.append(n % 2);
            n /= 2;
        }
        int len = ans.length();
        for (int i = 0; i < len - 1; i++)
            if (ans.charAt(i) == ans.charAt(i + 1))
                return false;
        return true;
    }
}