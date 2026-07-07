function sumAndMultiply(n: number): number {
    let x = 0;
    let sum = 0;
    let count = 0;
    while (n > 0) {
        let digit = n % 10;
        if (digit !== 0) {
            sum += digit;
            x = (digit * Math.pow(10, count)) + x;
            count++;
        }
        n = Math.floor(n / 10);
    }
    return sum * x;
};