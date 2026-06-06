function leftRightDifference(nums: number[]): number[] {
    let n = nums.length;
    if (n === 1) return [0];
    let ans: number[] = new Array(n);

    let leftSum: number[] = new Array(n);
    let rightSum: number[] = new Array(n);

    leftSum[0] = 0;
    rightSum[n - 1] = 0;
    for (let i = 1; i < n - 1; i++) {
        leftSum[i] = leftSum[i - 1] + nums[i - 1];
        rightSum[n - i - 1] = rightSum[n - i] + nums[n - i];
    }
    leftSum[n - 1] = leftSum[n - 2] + nums[n - 2];
    rightSum[0] = rightSum[1] + nums[1];

    for (let i = 0; i < n; i++)
        ans[i] = Math.abs(leftSum[i] - rightSum[i]);
    return ans;
};