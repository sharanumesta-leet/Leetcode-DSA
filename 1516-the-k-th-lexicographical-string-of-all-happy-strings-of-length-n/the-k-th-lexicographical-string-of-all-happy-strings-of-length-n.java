class Solution {
    public List<String> happyStrs = new ArrayList<>();

    public void generateHappyString(Map<Character, char[]> chars, char curChar, StringBuilder curStr, int n) {
        if (curStr.length() == n) {
            happyStrs.add(curStr.toString());
            return;
        }
        for (char ch : chars.get(curChar)) {
            curStr.append(ch);
            generateHappyString(chars, ch, curStr, n);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        if (3 * (1 << (n - 1)) < k)
            return "";
        Map<Character, char[]> chars = new HashMap<>();
        chars.put('a', new char[] { 'b', 'c' });
        chars.put('b', new char[] { 'a', 'c' });
        chars.put('c', new char[] { 'a', 'b' });

        for (char ch = 'a'; ch <= 'c'; ch++) {
            StringBuilder curStr = new StringBuilder();
            curStr.append(ch);
            generateHappyString(chars, ch, curStr, n);
        }
        return happyStrs.get(k - 1);
    }
}