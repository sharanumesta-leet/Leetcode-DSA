class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        int[] res = new int[ans.size()];
        i = 0;
        for (int num : ans)
            res[i++] = num;
        return res;
    }
}