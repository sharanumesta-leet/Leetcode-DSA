function minimumDeletions(nums: number[]): number {
    let n: number = nums.length;
    if (n === 1) return n;

    let min = 0;
    let max = 0;
    for (let i = 1; i < n; i++) {
        if (nums[i] < nums[min]) min = i;
        if (nums[i] > nums[max]) max = i;
    }

    let left = Math.min(min, max);
    let right = Math.max(min, max);

    return Math.min(right + 1, n - left, left + 1 + (n - right));
};