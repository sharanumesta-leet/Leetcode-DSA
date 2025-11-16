class Solution {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;
        int n = s.length();
        int result = 0;
        char[] sChar = s.toCharArray();
        int countOne = 0;
        for(int i = 0; i< n;i++){
            if(sChar[i] == '1') {
                countOne++;
                result = (result + countOne) % MOD;
            }
            else countOne = 0;
        }
        return result % MOD;
    }
}