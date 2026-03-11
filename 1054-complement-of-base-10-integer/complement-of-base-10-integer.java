class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder ans = new StringBuilder();

        for (char bit : binary.toCharArray())
            ans.append(bit == '0' ? '1' : '0');

        return Integer.parseInt(ans.toString(), 2);
    }
}