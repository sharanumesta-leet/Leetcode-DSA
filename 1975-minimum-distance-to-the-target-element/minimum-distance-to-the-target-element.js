/**
 * @param {number[]} nums
 * @param {number} target
 * @param {number} start
 * @return {number}
 */
var getMinDistance = function (nums, target, start) {
    let ans = Infinity;
    let n = nums.length;
    for (let i = 0; i < n; i++)
        if (nums[i] === target)
            ans = Math.min(ans, Math.abs(i - start));
    return ans;
};