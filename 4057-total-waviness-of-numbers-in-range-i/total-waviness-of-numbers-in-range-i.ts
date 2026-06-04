function totalWaviness(num1: number, num2: number): number {
    if (num2 < 100) return 0;
    let count: number = 0;
    for (let num = Math.max(num1, 100); num <= num2; num++) {
        let arr: number[] = getNumArray(num);
        count += countWaviness(arr);
    }
    return count;
};

const getNumArray = (num: number): number[] => {
    let arr: number[] = [];
    while (num > 0) {
        let digit = (num % 10);
        arr.push(digit);
        num = Math.floor(num / 10);
    }
    return arr;
}
const countWaviness = (nums: number[]): number => {
    let count: number = 0;
    for (let i = 1; i < nums.length - 1; i++)
        if (
            (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) ||
            (nums[i - 1] > nums[i] && nums[i] < nums[i + 1])
        )
            count++;
    return count;
}