function longestValidParentheses(s: string): number {
    let open: number = 0;
    let close: number = 0;
    let ans = 0;
    let n: number = s.length;
    for (let ch of s) {
        if (ch == '(') open++;
        else close++;

        if (open === close)
            ans = Math.max(ans, 2 * close);
        else if (close > open) {
            open = 0;
            close = 0;
        }
    }
    open = 0;
    close = 0;

    for (let i = n - 1; i >= 0; i--) {
        let ch = s[i];
        if (ch === ')')
            close++;
        else
            open++;
        if (open === close)
            ans = Math.max(ans, 2 * close);
        else if (close < open) {
            open = 0;
            close = 0;
        }
    }
    return ans;
};