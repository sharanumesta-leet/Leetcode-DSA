function minSwaps(nums: number[]): number {
    let n: number = nums.length;
    let i: number = 0;
    let sumArr: number[][] = [];
    for (let num of nums) {
        let sum = digitSum(num);
        sumArr.push([i++, sum]);
    }
    sumArr.sort((a: number[], b: number[]) => {
        if (a[1] === b[1]) {
            if (nums[a[0]] < nums[b[0]])
                return -1;
            else
                return 1;
        }
        else if (a[1] < b[1])
            return -1;
        else
            return 1;
    });

    let ans: number = 0;
    let visited: boolean[] = new Array(n).fill(false);
    for (i = 0; i < n; i++) {
        if (visited[i]) continue;

        let j: number = i;
        let cycleLen: number = 0;

        while (!visited[j]) {
            visited[j] = true;
            j = sumArr[j][0];
            cycleLen++;
        }
        if (cycleLen > 1) {
            ans += cycleLen - 1;
        }
    }
    return ans;
};

const digitSum = (num: number): number => {
    let sum = 0;
    while (num > 0) {
        let digit: number = num % 10;
        sum += digit;
        num = Math.floor(num / 10);
    }
    return sum;
}