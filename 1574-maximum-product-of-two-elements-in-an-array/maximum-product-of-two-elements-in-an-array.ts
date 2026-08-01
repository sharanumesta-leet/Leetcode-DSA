function maxProduct(nums: number[]): number {
    let a = 0;
    let b = 0;
    for (let num of nums) {
        if (num >= a) {
            b = a;
            a = num;
        } else if (num > b)
            b = num;
    }
    return (a - 1) * (b - 1);
};