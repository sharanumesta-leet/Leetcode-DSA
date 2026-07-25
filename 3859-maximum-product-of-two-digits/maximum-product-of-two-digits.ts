function maxProduct(n: number): number {
    let a = -1;
    let b = -1;
    while (n > 0) {
        let d = n % 10;
        if (d > a) {
            b = a;
            a = d;
        } else if (d >= b)
            b = d;

        n = Math.floor(n / 10);
    }
    return a * b;
};