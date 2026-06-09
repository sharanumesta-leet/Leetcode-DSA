function maxTotalValue(nums: number[], k: number): number {
    let n = nums.length;
    let max = -Infinity;
    let min = Infinity;
    for (let num of nums) {
        max = Math.max(max, num);
        min = Math.min(min, num);
    }
    return k * (max - min);
};