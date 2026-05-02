const invalidNum = new Set([3, 4, 7]);
const validNum = new Set([2, 5, 6, 9]);

function rotatedDigits(n: number): number {
    let ans: number = 0;
    for (let i = 1; i <= n; i++)
        if (isValidDigit(i)) ans++;
    return ans;
};

const isValidDigit = (num: number): boolean => {
    let isValidNum: boolean = false;
    while (num > 0) {
        let digit: number = num % 10;
        if (invalidNum.has(digit)) return false;
        if (validNum.has(digit)) isValidNum = true;
        num = Math.floor(num / 10);
    }
    return isValidNum;
}