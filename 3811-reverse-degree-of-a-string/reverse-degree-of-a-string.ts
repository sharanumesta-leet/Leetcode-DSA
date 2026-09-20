function reverseDegree(s: string): number {
    let n: number = s.length;
    let ans: number = 0;
    for (let i = 0; i < n; i++) {
        let code = 26 - (s[i].charCodeAt(0) - 'a'.charCodeAt(0));
        ans += (code * (i + 1));
    }
    return ans;
};