function removeOuterParentheses(s: string): string {
    let ans: string[] = [];
    let count: number = 0;
    for (let ch of s) {
        if (ch === '(') {
            if (count !== 0)
                ans.push(ch);
            count++;
        } else {
            count--;
            if (count !== 0)
                ans.push(ch);
        }
    }
    return ans.join("");
};