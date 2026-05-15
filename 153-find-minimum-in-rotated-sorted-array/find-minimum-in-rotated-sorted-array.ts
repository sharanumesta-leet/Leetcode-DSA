function findMin(nums: number[]): number {
    let n = nums.length;
    let l = 0;
    let r = n - 1;
    while (l < r) {
        let mid = l + Math.floor((r - l) / 2);
        if (nums[mid] > nums[r]) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return nums[l];
};