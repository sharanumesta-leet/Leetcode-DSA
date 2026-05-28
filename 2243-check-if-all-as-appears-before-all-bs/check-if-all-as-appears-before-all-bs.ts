function checkString(s: string): boolean {
    let n: number = s.length;
    let ch: string[] = s.split('');
    for (let i = 0; i < n - 1; i++)
        if (ch[i].charCodeAt(0) > ch[i + 1].charCodeAt(0))
            return false;
    return true;
};