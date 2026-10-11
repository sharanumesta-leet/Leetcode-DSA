function sumOfSquares(nums: number[]): number {
    let ans: number = 0;
    let n: number = nums.length;
    for (let i = 1; i <= n; i++) {
        if ((n % i) === 0) {
            let num: number = nums[i - 1];
            ans += (num * num);
        }
    }
    return ans;
};