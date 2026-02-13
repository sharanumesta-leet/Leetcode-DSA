class Solution {
    public int longestByOneChar(String s) {
        int ans = 1;
        int temp = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                temp++;
            else
                temp = 1;
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public int longestByTwoChar(String s, char c1, char c2) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == c1)
                temp++;
            else if (ch == c2)
                temp--;
            else {
                temp = 0;
                map = new HashMap<>();
                map.put(0, i);
            }
            if (map.containsKey(temp))
                ans = Math.max(ans, i - map.get(temp));
            else
                map.put(temp, i);
        }
        return ans;
    }

    public int longestByThreeChar(String s) {
        int a = 0, b = 0, c = 0;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        String key = "0-0";
        map.put(key, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                a++;
            else if (ch == 'b')
                b++;
            else
                c++;

            int a_b = a - b;
            int b_c = b - c;
            key = a_b + "-" + b_c;
            if (map.containsKey(key))
                ans = Math.max(ans, i - map.get(key));
            else
                map.put(key, i);
        }
        return ans;
    }

    public int longestBalanced(String s) {
        int oneLen = longestByOneChar(s);

        char a = 'a', b = 'b', c = 'c';
        int a_b = longestByTwoChar(s, a, b);
        int b_c = longestByTwoChar(s, b, c);
        int a_c = longestByTwoChar(s, a, c);
        int twoLen = Math.max(a_b, Math.max(a_c, b_c));

        int threeLen = longestByThreeChar(s);

        return Math.max(oneLen, Math.max(twoLen, threeLen));
    }
}