function scoreOfParentheses(s: string): number {
    let cur: number = 0;
    let st: number[] = [0];
    for (let i = 0; i < s.length; i++) {
        let ch = s[i];
        if (ch === '(') {
            st.push(cur);
            cur = 0;
        } else {
            if (s[i - 1] === '(')
                cur = 1;
            else
                cur *= 2;
            cur += st.pop();
        }
    }
    return cur;
};