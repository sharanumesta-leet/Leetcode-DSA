function separateDigits(nums: number[]): number[] {
    let ans: number[] = [];
    for (let num of nums) {
        let temp: number[] = [];
        while (num > 0) {
            let digit = num % 10;
            num = Math.floor(num / 10);
            temp.push(digit);
        }
        for (let i = temp.length - 1; i >= 0; i--)
            ans.push(temp[i]);
    }
    return ans;
};