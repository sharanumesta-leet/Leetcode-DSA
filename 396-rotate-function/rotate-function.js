/**
 * @param {number[]} nums
 * @return {number}
 */
var maxRotateFunction = function (nums) {
    let n = nums.length;
    let ans = -Infinity;
    let f0 = 0;
    let totalSum = 0;
    for (let i = 0; i < n; i++) {
        f0 += (nums[i] * i);
        totalSum += nums[i];
    }
    ans = f0;
    let prev = f0;
    for (let i = n - 1; i > 0; i--) {
        let cur = prev + totalSum - (n * nums[i]);
        ans = Math.max(ans, cur);
        prev = cur;
    }
    return ans;
};