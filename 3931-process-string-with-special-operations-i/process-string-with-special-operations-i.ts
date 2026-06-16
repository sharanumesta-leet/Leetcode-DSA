function processStr(s: string): string {
    let ans: string[] = [];
    for (let ch of s.split('')) {
        if (ch === '*') {
            if (ans.length > 0)
                ans.pop();
        }
        else if ((ch === '#')) {
            if (ans.length !== 0)
                ans.push(...ans);
        }
        else if (ch === '%') {
            if (ans.length !== 0)
                ans.reverse();
        }
        else
            ans.push(ch);
    }
    return ans.join('');
};