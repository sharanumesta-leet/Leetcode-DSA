function countMajoritySubarrays(nums: number[], target: number): number {
    let n: number = nums.length;
    let ans: number = 0;
    for (let i = 0; i < n; i++) {
        let count = 0;
        for (let j = i; j < n; j++) {
            if (nums[j] === target)
                count++;
            if (count > Math.floor((j - i + 1) / 2))
                ans++;
        }
    }
    return ans;
};