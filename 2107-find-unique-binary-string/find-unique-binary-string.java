class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        Set<Integer> decNum = new HashSet<>();
        for (String binary : nums)
            decNum.add(Integer.parseInt(binary, 2));

        int m = (int) Math.pow(2, n);
        for (int i = 0; i < m; i++)
            if (!decNum.contains(i))
                return String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');

        return "";
    }
}