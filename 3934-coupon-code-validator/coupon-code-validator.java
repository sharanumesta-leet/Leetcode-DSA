class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++)
            idx[i] = i;

        Arrays.sort(idx, (a, b) -> {
            if (businessLine[a].equals(businessLine[b]))
                return code[a].compareTo(code[b]);
            else
                return businessLine[a].compareTo(businessLine[b]);
        });

        List<String> ans = new ArrayList<>();
        String regex = "^[A-Za-z0-9_]+$";
        Set<String> categories = Set.of("electronics", "grocery", "pharmacy", "restaurant");

        for (int id : idx)
            if (isActive[id] && code[id].matches(regex) && categories.contains(businessLine[id]))
                ans.add(code[id]);

        return ans;
    }
}
