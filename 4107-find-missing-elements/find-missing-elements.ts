function findMissingElements(nums: number[]): number[] {
    nums.sort((a, b) => a - b);
    let min: number = nums[0];
    let max: number = nums[nums.length - 1];
    let ans: number[] = [];
    if (max - min + 1 === nums.length) return ans;

    let i: number = 0;
    let cur: number = min;

    while (cur < max) {
        if (cur === nums[i]) i++;
        else ans.push(cur);
        cur++;
    }
    return ans;
};