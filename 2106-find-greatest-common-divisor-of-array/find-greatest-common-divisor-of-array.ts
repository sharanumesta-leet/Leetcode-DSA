function findGCD(nums: number[]): number {
    let min = Infinity;
    let max = 0;
    min = Math.min(...nums);
    max = Math.max(...nums);
    return gcd(min, max);
};

const gcd = (a, b): number => {
    return (b === 0) ? a : gcd(b, a % b);
}