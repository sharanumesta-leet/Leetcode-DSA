class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int idx = 0;
        for (int num : nums) {
            if (set.contains(num))
                res[idx++] = num;
            else
                set.add(num);

            if (idx == 2)
                break;
        }
        return res;
    }
}