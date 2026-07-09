function maxPower(s: string): number {
    let n = s.length;
    let count = 1;
    let ans = 1;
    for (let i = 0; i < n - 1; i++) {
        if (s[i] === s[i + 1]) count++;
        else count = 1;
        ans = Math.max(ans, count);
    }
    return ans;
};