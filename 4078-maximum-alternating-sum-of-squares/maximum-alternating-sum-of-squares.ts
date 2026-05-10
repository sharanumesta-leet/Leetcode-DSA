function maxAlternatingSum(nums: number[]): number {
    let n = nums.length;
    for (let i = 0; i < n; i++) nums[i] = Math.abs(nums[i]);
    nums.sort((a, b) => b - a);
    let ans: number = 0;
    let l = 0;
    let r = n - 1;
    while (l < r) {
        ans += Math.pow(nums[l], 2) - Math.pow(nums[r], 2);
        l++;
        r--;
    }
    if (l === r) ans += Math.pow(nums[l], 2);
    return ans;
};