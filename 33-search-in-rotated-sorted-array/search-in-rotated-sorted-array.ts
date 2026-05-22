function search(nums: number[], target: number): number {
    let n: number = nums.length;
    let l: number = 0;
    let r: number = n - 1;
    while (l <= r) {
        let m: number = l + Math.floor((r - l) / 2);
        let left = nums[l];
        let right = nums[r];
        let mid = nums[m];
        if (mid === target) return m;
        else if (left <= mid) {
            if (left <= target && target < mid)
                r = m - 1;
            else
                l = m + 1;
        } else {
            if (mid < target && target <= right)
                l = m + 1;
            else
                r = m - 1;
        }
    }
    return -1;
};