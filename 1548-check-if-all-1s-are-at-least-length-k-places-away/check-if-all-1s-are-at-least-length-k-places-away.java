class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int idx = 0;
        int n = nums.length;
        while ( idx < n && nums[idx] != 1)
            idx++;
        int dist = 0;
        for (int i = idx+1; i < n; i++) {
            if(nums[i] == 1) {
                if(dist < k)
                    return false;
                else dist = 0;
            }
            else dist++;
        }
        return true;
    }
}