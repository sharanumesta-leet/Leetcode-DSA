class Solution {
    public int binaryGap(int n) {
        if ((n & (n - 1)) == 0)
            return 0;
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.append(n % 2);
            n /= 2;
        }
        binary.reverse();
        int len = binary.length();
        int i = 0, ans = 0;
        while ((i < len) && (binary.charAt(i) == '0')) {
            i++;
        }
        while (i < len) {
            int j = i + 1;
            while ((j < len) && (binary.charAt(j) == '0'))
                j++;
            if (j < len)
                ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }
}