function minElement(nums: number[]): number {
    let min: number = Infinity;
    for (let num of nums) {
        let curSum: number = digitSum(num);
        min = Math.min(min, curSum);
    }
    return min;
};

let digitSum = (num: number): number => {
    let sum: number = 0;
    while (num > 0) {
        sum += (num % 10);
        num = Math.floor(num / 10);
    }
    return sum;
}