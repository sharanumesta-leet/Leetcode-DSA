class Solution {
    public List<String> printVertically(String s) {
        List<String> ans = new ArrayList<>();
        List<String> sList = Arrays.asList(s.split(" "));
        int n = sList.size();
        int maxLen = 0;
        for (String st : sList)
            maxLen = Math.max(maxLen, st.length());

        for (int i = 0; i < maxLen; i++) {
            StringBuilder word = new StringBuilder("");
            for (int j = 0; j < n; j++) {
                if (i < sList.get(j).length())
                    word.append(sList.get(j).charAt(i));
                else
                    word.append(" ");
            }
            ans.add(word.toString().replaceAll("\\s+$",""));
        }
        return ans;
    }
}