function numberOfSpecialChars(word: string): number {
    let lower: Set<string> = new Set();
    let upper: Set<string> = new Set();
    let count = 0;

    for (let ch of word) {
        if (ch >= 'a' && ch <= 'z')
            lower.add(ch);
        else
            upper.add(ch);
    }
    for (let ch of lower)
        if (upper.has(ch.toUpperCase()))
            count++;
    return count;
};