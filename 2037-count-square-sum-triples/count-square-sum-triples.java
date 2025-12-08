class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i < n; i++)
            for (int j = i + 1; j <= n; j++) {
                double num = Math.sqrt((i * i) + (j * j));
                boolean isInteger = Math.floor(num) == num;
                if (isInteger && (int) num <= n)
                    count+=2;
            }
        return count;
    }
}