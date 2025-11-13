class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int result = 0;
        int countZero = 0;
        char[] charArr = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            if ( i > 0 && charArr[i] == '0' && charArr[i - 1] == '1')
                countZero++;
            else if (charArr[i] == '1')
                result += countZero;
        }
        return result;
    }
}