class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int a = arr[i];
            int b = arr[i - 1];
            int dif = a - b;
            if (!map.containsKey(dif))
                map.put(dif, new ArrayList<>());
            map.get(dif).add(Arrays.asList(b,a));
            minDif = Math.min(minDif, dif);
        }
        return map.get(minDif);
    }
}